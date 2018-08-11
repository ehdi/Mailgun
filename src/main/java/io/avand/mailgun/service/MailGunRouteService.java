package io.avand.mailgun.service;

import io.avand.mailgun.service.dto.request.MailGunCreateRouteRequestDTO;
import io.avand.mailgun.service.dto.request.MailGunGetAllRouteRequestDTO;
import io.avand.mailgun.service.dto.request.MailGunGetRouteByIdRequestDTO;
import io.avand.mailgun.service.dto.response.MailGunCreateRouteResponseDTO;
import io.avand.mailgun.service.dto.response.MailGunGetAllRouteResponseDTO;
import io.avand.mailgun.service.dto.response.MailGunGetRouteByIdResponseDTO;
import io.avand.mailgun.service.error.MailGunException;

public interface MailGunRouteService {

    MailGunCreateRouteResponseDTO createRoute(MailGunCreateRouteRequestDTO requestDTO) throws MailGunException;

    MailGunGetRouteByIdResponseDTO getRouteById(MailGunGetRouteByIdRequestDTO requestDTO) throws MailGunException;

    MailGunGetAllRouteResponseDTO getAllRoute(MailGunGetAllRouteRequestDTO requestDTO) throws MailGunException;

}
