package hr.pishe.mailgun.repository;

import hr.pishe.mailgun.service.dto.request.MailGunSendMessageRequestDTO;
import hr.pishe.mailgun.service.dto.response.MailGunSendMessageResponseDTO;
import org.springframework.http.ResponseEntity;

public interface MailGunMessageRepository {

    ResponseEntity<MailGunSendMessageResponseDTO> send(MailGunSendMessageRequestDTO requestDTO);

}
