package io.avand.mailgun.repository.impl;

import io.avand.mailgun.config.MailGunConfig;
import io.avand.mailgun.repository.MailGunRouteRepository;
import io.avand.mailgun.repository.util.HeaderUtil;
import io.avand.mailgun.service.dto.request.MailGunCreateRouteRequestDTO;
import io.avand.mailgun.service.dto.request.MailGunGetAllRouteRequestDTO;
import io.avand.mailgun.service.dto.request.MailGunGetRouteByIdRequestDTO;
import io.avand.mailgun.service.dto.response.MailGunCreateRouteResponseDTO;
import io.avand.mailgun.service.dto.response.MailGunGetAllRouteResponseDTO;
import io.avand.mailgun.service.dto.response.MailGunGetRouteByIdResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
public class MailGunRouteRepositoryImpl implements MailGunRouteRepository {

    private final Logger log = LoggerFactory.getLogger(MailGunRouteRepositoryImpl.class);

    private final MailGunConfig mailGunConfig;

    public MailGunRouteRepositoryImpl(MailGunConfig mailGunConfig) {
        this.mailGunConfig = mailGunConfig;
    }

    @Override
    public ResponseEntity<MailGunCreateRouteResponseDTO> createRoute(MailGunCreateRouteRequestDTO requestDTO) {
        log.debug("Request to create route via repository : {}", requestDTO);
        LinkedMultiValueMap<String, String> valueMap = new LinkedMultiValueMap<>();
        valueMap.add("priority", "0");
        valueMap.add("description", requestDTO.getDescription());
        valueMap.add("expression", "match_recipient('" + requestDTO.getMatchRecipient() + "')");
        valueMap.add("action", "forward('" + requestDTO.getForwardTo() + "')");

        HttpEntity<LinkedMultiValueMap<String, String>> request =
                new HttpEntity<>(valueMap, HeaderUtil.createHeader(mailGunConfig.getUsername(), mailGunConfig.getApiKey()));
        return new RestTemplate()
                .exchange(
                        "https://api.mailgun.net/v3/routes",
                        HttpMethod.POST,
                        request,
                        MailGunCreateRouteResponseDTO.class
                );
    }

    @Override
    public ResponseEntity<MailGunGetRouteByIdResponseDTO> getRouteById(MailGunGetRouteByIdRequestDTO requestDTO) {
        log.debug("Request to get route by id via repository : {}", requestDTO);

        HttpEntity request =
                new HttpEntity<>(HeaderUtil.createHeader(mailGunConfig.getUsername(), mailGunConfig.getApiKey()));
        return new RestTemplate()
                .exchange(
                        "https://api.mailgun.net/v3/routes/" + requestDTO.getRouteId(),
                        HttpMethod.GET,
                        request,
                        MailGunGetRouteByIdResponseDTO.class
                );
    }

    @Override
    public ResponseEntity<MailGunGetAllRouteResponseDTO> getAllRoute(MailGunGetAllRouteRequestDTO requestDTO) {
        log.debug("Request to get all route via repository : {}", requestDTO);
        UriComponentsBuilder builder =
                UriComponentsBuilder.fromUriString("https://api.mailgun.net/v3/routes")
                        .queryParam("skip", requestDTO.getSkip())
                        .queryParam("limit", requestDTO.getLimit());

        HttpEntity request =
                new HttpEntity<>(HeaderUtil.createHeader(mailGunConfig.getUsername(), mailGunConfig.getApiKey()));
        return new RestTemplate()
                .exchange(
                        builder.build().toUri(),
                        HttpMethod.GET,
                        request,
                        MailGunGetAllRouteResponseDTO.class
                );
    }
}
