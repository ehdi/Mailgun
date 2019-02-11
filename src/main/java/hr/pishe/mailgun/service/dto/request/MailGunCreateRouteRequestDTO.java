package hr.pishe.mailgun.service.dto.request;

import java.io.Serializable;

public class MailGunCreateRouteRequestDTO implements Serializable {

    private String description;
    private String matchRecipient;
    private String forwardTo;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMatchRecipient() {
        return matchRecipient;
    }

    public void setMatchRecipient(String matchRecipient) {
        this.matchRecipient = matchRecipient;
    }

    public String getForwardTo() {
        return forwardTo;
    }

    public void setForwardTo(String forwardTo) {
        this.forwardTo = forwardTo;
    }

    @Override
    public String toString() {
        return "MailGunCreateRouteRequestDTO{" +
                "description='" + description + '\'' +
                ", matchRecipient='" + matchRecipient + '\'' +
                ", forwardTo='" + forwardTo + '\'' +
                '}';
    }
}
