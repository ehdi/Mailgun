package hr.pishe.mailgun.service.dto.request;

import java.io.Serializable;

public class MailGunGetAllRouteRequestDTO implements Serializable {

    private String skip;
    private String limit;

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "MailGunGetAllRouteRequestDTO{" +
                "skip=" + skip +
                ", limit=" + limit +
                '}';
    }
}
