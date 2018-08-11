package io.avand.mailgun.service.dto.response;

import io.avand.mailgun.service.dto.MailGunRouteDTO;

import java.io.Serializable;

public class MailGunGetRouteByIdResponseDTO implements Serializable {

    private MailGunRouteDTO route;

    public MailGunRouteDTO getRoute() {
        return route;
    }

    public void setRoute(MailGunRouteDTO route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "MailGunGetRouteByIdResponseDTO{" +
                "route=" + route +
                '}';
    }
}
