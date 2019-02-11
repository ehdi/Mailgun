package hr.pishe.mailgun.service.impl;

import hr.pishe.mailgun.repository.MailGunMessageRepository;
import hr.pishe.mailgun.service.dto.request.MailGunSendMessageRequestDTO;
import hr.pishe.mailgun.service.dto.response.MailGunSendMessageResponseDTO;
import hr.pishe.mailgun.service.error.MailGunException;
import hr.pishe.mailgun.config.MailGunConfig;
import hr.pishe.mailgun.service.MailGunMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(MailGunConfig.class)
public class MailGunMessageServiceImpl implements MailGunMessageService {

    private final Logger log = LoggerFactory.getLogger(MailGunMessageServiceImpl.class);

    private final MailGunMessageRepository repository;

    public MailGunMessageServiceImpl(MailGunMessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public MailGunSendMessageResponseDTO sendMessage(MailGunSendMessageRequestDTO requestDTO) throws MailGunException {
        log.debug("Request to send message via service : {}", requestDTO);
        ResponseEntity<MailGunSendMessageResponseDTO> response = repository.send(requestDTO);
        if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody();
        } else {
            throw new MailGunException(String.format("Failed To Send Message : %s", response.getStatusCode()));
        }
    }
}
