package io.avand.mailgun.service;

import io.avand.mailgun.service.dto.request.MailGunSendMessageRequestDTO;
import io.avand.mailgun.service.dto.response.MailGunSendMessageResponseDTO;
import io.avand.mailgun.service.error.MailGunException;

public interface MailGunMessageService {

    MailGunSendMessageResponseDTO sendMessage(MailGunSendMessageRequestDTO requestDTO) throws MailGunException;

}
