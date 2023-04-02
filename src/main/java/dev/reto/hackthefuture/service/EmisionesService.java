package dev.reto.hackthefuture.service;

import dev.reto.hackthefuture.service.dto.EmisionesDTO;
import dev.reto.hackthefuture.service.dto.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface EmisionesService {
    ResponseEntity<GenericResponseDTO> getEmisionesById(Long pId);

    ResponseEntity<GenericResponseDTO> addEmisiones(EmisionesDTO pEmisionesDTO);
}
