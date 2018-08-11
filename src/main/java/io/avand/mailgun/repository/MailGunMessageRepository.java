package io.avand.mailgun.repository;

import com.fasterxml.jackson.databind.JsonNode;
import io.avand.mailgun.service.dto.request.MailGunSendMessageRequestDTO;
import io.avand.mailgun.service.dto.response.MailGunSendMessageResponseDTO;
import org.springframework.http.ResponseEntity;

public interface MailGunMessageRepository {

    ResponseEntity<MailGunSendMessageResponseDTO> send(MailGunSendMessageRequestDTO requestDTO);

}
