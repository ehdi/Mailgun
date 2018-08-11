package io.avand.mailgun.service.dto.request;

import java.io.Serializable;

public class MailGunGetRouteByIdRequestDTO implements Serializable{

    private String routeId;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "MailGunGetRouteByIdRequestDTO{" +
                "routeId='" + routeId + '\'' +
                '}';
    }
}
