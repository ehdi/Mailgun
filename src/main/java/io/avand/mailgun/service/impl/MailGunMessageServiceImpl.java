package io.avand.mailgun.service.impl;

import io.avand.mailgun.repository.MailGunMessageRepository;
import io.avand.mailgun.service.MailGunMessageService;
import io.avand.mailgun.service.dto.request.MailGunSendMessageRequestDTO;
import io.avand.mailgun.service.dto.response.MailGunSendMessageResponseDTO;
import io.avand.mailgun.service.error.MailGunException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
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
