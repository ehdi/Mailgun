package hr.pishe.mailgun.service.dto.response;

import hr.pishe.mailgun.service.dto.MailGunRouteDTO;

import java.io.Serializable;

public class MailGunCreateRouteResponseDTO implements Serializable {

    private String message;
    private MailGunRouteDTO route;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MailGunRouteDTO getRoute() {
        return route;
    }

    public void setRoute(MailGunRouteDTO route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "MailGunCreateRouteResponseDTO{" +
                "message='" + message + '\'' +
                ", route=" + route +
                '}';
    }
}
