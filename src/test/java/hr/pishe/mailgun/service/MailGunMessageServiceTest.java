package hr.pishe.mailgun.service;


import hr.pishe.mailgun.service.dto.request.MailGunSendMessageRequestDTO;
import hr.pishe.mailgun.service.dto.response.MailGunSendMessageResponseDTO;
import hr.pishe.mailgun.service.error.MailGunException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
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

