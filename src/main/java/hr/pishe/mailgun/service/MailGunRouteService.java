package hr.pishe.mailgun.service;

import hr.pishe.mailgun.service.dto.request.MailGunCreateRouteRequestDTO;
import hr.pishe.mailgun.service.dto.request.MailGunGetAllRouteRequestDTO;
import hr.pishe.mailgun.service.dto.request.MailGunGetRouteByIdRequestDTO;
import hr.pishe.mailgun.service.dto.response.MailGunCreateRouteResponseDTO;
import hr.pishe.mailgun.service.dto.response.MailGunGetAllRouteResponseDTO;
import hr.pishe.mailgun.service.dto.response.MailGunGetRouteByIdResponseDTO;
import hr.pishe.mailgun.service.error.MailGunException;

public interface MailGunRouteService {

    MailGunCreateRouteResponseDTO createRoute(MailGunCreateRouteRequestDTO requestDTO) throws MailGunException;

    MailGunGetRouteByIdResponseDTO getRouteById(MailGunGetRouteByIdRequestDTO requestDTO) throws MailGunException;

    MailGunGetAllRouteResponseDTO getAllRoute(MailGunGetAllRouteRequestDTO requestDTO) throws MailGunException;

}
