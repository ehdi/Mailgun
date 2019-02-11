package hr.pishe.mailgun.service.error;

public class MailGunException extends Exception {

    public MailGunException(String message) {
        super(message);
    }
}
