package hr.pishe.mailgun.service.dto.request;

import java.io.File;
import java.io.Serializable;

public class MailGunSendMessageRequestDTO implements Serializable {
    private String fromName;
    private String to;
    private String subject;
    private String text;
    private String html;
    private File attachment;

    public MailGunSendMessageRequestDTO() {
    }

    public String getFromName() {
        return this.fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHtml() {
        return this.html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public File getAttachment() {
        return this.attachment;
    }

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }

    public String toString() {
        return "MailGunSendMessageRequestDTO{fromName='" + this.fromName + '\'' + ", to='" + this.to + '\'' + ", subject='" + this.subject + '\'' + ", text='" + this.text + '\'' + ", html='" + this.html + '\'' + '}';
    }
}
