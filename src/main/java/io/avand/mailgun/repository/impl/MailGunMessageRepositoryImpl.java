package io.avand.mailgun.repository.impl;

import io.avand.mailgun.config.MailGunConfig;
import io.avand.mailgun.repository.util.HeaderUtil;
import io.avand.mailgun.repository.MailGunMessageRepository;
import io.avand.mailgun.service.dto.request.MailGunSendMessageRequestDTO;
import io.avand.mailgun.service.dto.response.MailGunSendMessageResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
public class MailGunMessageRepositoryImpl implements MailGunMessageRepository {

    private final Logger log = LoggerFactory.getLogger(MailGunMessageRepositoryImpl.class);

    private final MailGunConfig mailGunConfig;

    public MailGunMessageRepositoryImpl(MailGunConfig mailGunConfig) {
        this.mailGunConfig = mailGunConfig;
    }

    @Override
    public ResponseEntity<MailGunSendMessageResponseDTO> send(MailGunSendMessageRequestDTO requestDTO) {
        log.debug("Request to send message via repository : {}", requestDTO);
        UriComponentsBuilder builder =
                UriComponentsBuilder.fromUriString("https://api.mailgun.net/v3/" + mailGunConfig.getDomain() + "/messages")
                        .queryParam("from", mailGunConfig.getFrom())
                        .queryParam("to", requestDTO.getTo())
                        .queryParam("subject", requestDTO.getSubject())
                        .queryParam("text", requestDTO.getText())
                        .queryParam("html", requestDTO.getHtml());

        HttpEntity request =
                new HttpEntity<>(HeaderUtil.createHeader("api",mailGunConfig.getApiKey()));
        return new RestTemplate()
                .exchange(builder.build().toUri(), HttpMethod.POST,request,MailGunSendMessageResponseDTO.class);
    }
}