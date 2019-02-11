package hr.pishe.mailgun.repository;

import hr.pishe.mailgun.service.dto.request.MailGunCreateRouteRequestDTO;
import hr.pishe.mailgun.service.dto.request.MailGunGetAllRouteRequestDTO;
import hr.pishe.mailgun.service.dto.request.MailGunGetRouteByIdRequestDTO;
import hr.pishe.mailgun.service.dto.response.MailGunCreateRouteResponseDTO;
import hr.pishe.mailgun.service.dto.response.MailGunGetAllRouteResponseDTO;
import hr.pishe.mailgun.service.dto.response.MailGunGetRouteByIdResponseDTO;
import org.springframework.http.ResponseEntity;

public interface MailGunRouteRepository {

    ResponseEntity<MailGunCreateRouteResponseDTO> createRoute(MailGunCreateRouteRequestDTO requestDTO);

    ResponseEntity<MailGunGetRouteByIdResponseDTO> getRouteById(MailGunGetRouteByIdRequestDTO requestDTO);

    ResponseEntity<MailGunGetAllRouteResponseDTO> getAllRoute(MailGunGetAllRouteRequestDTO requestDTO);

}
