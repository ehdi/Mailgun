package io.avand.mailgun.service;

import io.avand.mailgun.MailgunApplication;
import io.avand.mailgun.service.dto.request.MailGunSendMessageRequestDTO;
import io.avand.mailgun.service.dto.response.MailGunSendMessageResponseDTO;
import io.avand.mailgun.service.error.MailGunException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MailgunApplication.class)
public class MailGunMessageServiceTest {

    @Autowired
    private MailGunMessageService mailGunMessageService;

    @Test
    public void sendMessage() {
        MailGunSendMessageRequestDTO requestDTO = new MailGunSendMessageRequestDTO();
        requestDTO.setTo("pouyaashna@gmail.com");
        requestDTO.setSubject("Active");
        requestDTO.setText("Hiiii");

        try {
            MailGunSendMessageResponseDTO responseDTO = mailGunMessageService.sendMessage(requestDTO);
            System.out.println(responseDTO);
        } catch (MailGunException e) {
            System.out.println(e.getMessage());
        }
    }

}

