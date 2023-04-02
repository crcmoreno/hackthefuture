package dev.reto.hackthefuture.web.rest;

import dev.reto.hackthefuture.service.EmisionesService;
import dev.reto.hackthefuture.service.dto.EmisionesDTO;
import dev.reto.hackthefuture.service.dto.GenericResponseDTO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApis {

    private final Logger log = LoggerFactory.getLogger(PostApis.class);

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private EmisionesService emisionesService;

    public PostApis(EmisionesService emisionesService) {
        this.emisionesService = emisionesService;
    }

    @PostMapping(value = "/open/add/combustible/administrativo/", produces = "application/json")
    public ResponseEntity<GenericResponseDTO> addCombustibleAdministrativo(@RequestBody EmisionesDTO pEmisionesDTO) {
        ResponseEntity<GenericResponseDTO> response = null;
        try {
            log.debug("REST request to add combustible-administrativo : {}", pEmisionesDTO.toString());
            response = emisionesService.addEmisiones(pEmisionesDTO);
        } catch (Exception e) {
            String error = String.format("Error in addCombustibleAdministrativo: %s", e.getMessage());
            log.error(error);
            GenericResponseDTO errorResponse = new GenericResponseDTO(
                "500",
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                e.getMessage()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
        return response;
    }
}
