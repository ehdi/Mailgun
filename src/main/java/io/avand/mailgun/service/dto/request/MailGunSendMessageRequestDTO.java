package io.avand.mailgun.service.dto.request;

import java.io.Serializable;

public class MailGunSendMessageRequestDTO implements Serializable {

    private String to;
    private String subject;
    private String text;
    private String html;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    @Override
    public String toString() {
        return "MailGunSendMessageRequestDTO{" +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", html='" + html + '\'' +
                '}';
    }
}
