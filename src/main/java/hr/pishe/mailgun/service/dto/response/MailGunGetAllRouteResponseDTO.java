package hr.pishe.mailgun.service.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import hr.pishe.mailgun.service.dto.MailGunRouteDTO;

import java.io.Serializable;
import java.util.List;

public class MailGunGetAllRouteResponseDTO implements Serializable {

    @JsonProperty("total_count")
    private Long totalCount;

    private List<MailGunRouteDTO> items;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<MailGunRouteDTO> getItems() {
        return items;
    }

    public void setItems(List<MailGunRouteDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "MailGunGetAllRouteResponseDTO{" +
                "totalCount=" + totalCount +
                ", items=" + items +
                '}';
    }
}
