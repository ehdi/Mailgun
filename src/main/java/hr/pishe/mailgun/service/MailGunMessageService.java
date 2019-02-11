package hr.pishe.mailgun.service;

import hr.pishe.mailgun.service.dto.request.MailGunSendMessageRequestDTO;
import hr.pishe.mailgun.service.dto.response.MailGunSendMessageResponseDTO;
import hr.pishe.mailgun.service.error.MailGunException;

public interface MailGunMessageService {

    MailGunSendMessageResponseDTO sendMessage(MailGunSendMessageRequestDTO requestDTO) throws MailGunException;

}
