package io.avand.mailgun.service.dto.response;

import com.mashape.unirest.http.ObjectMapper;

import java.io.Serializable;

public class MailGunSendMessageResponseDTO implements Serializable{

    private String id;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MailGunSendMessageResponseDTO{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
