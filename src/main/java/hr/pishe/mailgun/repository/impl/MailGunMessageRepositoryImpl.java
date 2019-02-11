package hr.pishe.mailgun.repository.impl;

import hr.pishe.mailgun.repository.MailGunMessageRepository;
import hr.pishe.mailgun.service.dto.request.MailGunSendMessageRequestDTO;
import hr.pishe.mailgun.service.dto.response.MailGunSendMessageResponseDTO;
import hr.pishe.mailgun.config.MailGunConfig;
import hr.pishe.mailgun.repository.util.HeaderUtil;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Repository
public class MailGunMessageRepositoryImpl implements MailGunMessageRepository {
    private final Logger log = LoggerFactory.getLogger(MailGunMessageRepositoryImpl.class);
    private final MailGunConfig mailGunConfig;

    public MailGunMessageRepositoryImpl(MailGunConfig mailGunConfig) {
        this.mailGunConfig = mailGunConfig;
    }

    public ResponseEntity<MailGunSendMessageResponseDTO> send(MailGunSendMessageRequestDTO requestDTO) {
        this.log.debug("Request to send message via repository : {}", requestDTO);
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap();
        parts.add("from", requestDTO.getFromName() + " <" + this.mailGunConfig.getFrom() + ">");
        parts.add("to", requestDTO.getTo());
        parts.add("subject", requestDTO.getSubject());
        parts.add("text", requestDTO.getText());
        parts.add("html", requestDTO.getHtml());
        if (requestDTO.getAttachment() != null) {
            parts.add("attachment", new FileSystemResource(requestDTO.getAttachment()));
        }

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity(parts, HeaderUtil.createHeader("api", this.mailGunConfig.getApiKey(), requestDTO.getAttachment() == null ? null : ContentType.MULTIPART_FORM_DATA.toString()));
        return (new RestTemplate()).exchange("https://api.mailgun.net/v3/" + this.mailGunConfig.getDomain() + "/messages", HttpMethod.POST, requestEntity, MailGunSendMessageResponseDTO.class, new Object[0]);
    }
}
