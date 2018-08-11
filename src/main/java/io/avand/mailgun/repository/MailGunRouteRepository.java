package io.avand.mailgun.repository;

import io.avand.mailgun.service.dto.request.MailGunCreateRouteRequestDTO;
import io.avand.mailgun.service.dto.request.MailGunGetAllRouteRequestDTO;
import io.avand.mailgun.service.dto.request.MailGunGetRouteByIdRequestDTO;
import io.avand.mailgun.service.dto.response.MailGunCreateRouteResponseDTO;
import io.avand.mailgun.service.dto.response.MailGunGetAllRouteResponseDTO;
import io.avand.mailgun.service.dto.response.MailGunGetRouteByIdResponseDTO;
import org.springframework.http.ResponseEntity;

public interface MailGunRouteRepository {

    ResponseEntity<MailGunCreateRouteResponseDTO> createRoute(MailGunCreateRouteRequestDTO requestDTO);

    ResponseEntity<MailGunGetRouteByIdResponseDTO> getRouteById(MailGunGetRouteByIdRequestDTO requestDTO);

    ResponseEntity<MailGunGetAllRouteResponseDTO> getAllRoute(MailGunGetAllRouteRequestDTO requestDTO);

}
