package hr.pishe.mailgun.service.impl;

import hr.pishe.mailgun.service.dto.request.MailGunCreateRouteRequestDTO;
import hr.pishe.mailgun.service.dto.request.MailGunGetAllRouteRequestDTO;
import hr.pishe.mailgun.service.dto.request.MailGunGetRouteByIdRequestDTO;
import hr.pishe.mailgun.service.dto.response.MailGunCreateRouteResponseDTO;
import hr.pishe.mailgun.service.dto.response.MailGunGetAllRouteResponseDTO;
import hr.pishe.mailgun.service.dto.response.MailGunGetRouteByIdResponseDTO;
import hr.pishe.mailgun.service.error.MailGunException;
import hr.pishe.mailgun.config.MailGunConfig;
import hr.pishe.mailgun.repository.MailGunRouteRepository;
import hr.pishe.mailgun.service.MailGunRouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(MailGunConfig.class)
public class MailGunRouteServiceImpl implements MailGunRouteService {

    private final Logger log = LoggerFactory.getLogger(MailGunRouteServiceImpl.class);

    private final MailGunRouteRepository repository;

    public MailGunRouteServiceImpl(MailGunRouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public MailGunCreateRouteResponseDTO createRoute(MailGunCreateRouteRequestDTO requestDTO) throws MailGunException {
        log.debug("Request to create route via service : {}", requestDTO);
        ResponseEntity<MailGunCreateRouteResponseDTO> response = repository.createRoute(requestDTO);
        if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody();
        } else {
            throw new MailGunException(String.format("Failed To Create Route : %s", response.getStatusCodeValue()));
        }
    }

    @Override
    public MailGunGetRouteByIdResponseDTO getRouteById(MailGunGetRouteByIdRequestDTO requestDTO) throws MailGunException {
        log.debug("Request to get route by id via service : {}", requestDTO);
        ResponseEntity<MailGunGetRouteByIdResponseDTO> response = repository.getRouteById(requestDTO);
        if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody();
        } else {
            throw new MailGunException(String.format("Failed To Get Route By Id : %s", response.getStatusCodeValue()));
        }
    }

    @Override
    public MailGunGetAllRouteResponseDTO getAllRoute(MailGunGetAllRouteRequestDTO requestDTO) throws MailGunException {
        log.debug("Request to get all route via service : {}", requestDTO);
        ResponseEntity<MailGunGetAllRouteResponseDTO> response = repository.getAllRoute(requestDTO);
        if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody();
        } else {
            throw new MailGunException(String.format("Failed To Get All Route : %s", response.getStatusCodeValue()));
        }
    }
}
