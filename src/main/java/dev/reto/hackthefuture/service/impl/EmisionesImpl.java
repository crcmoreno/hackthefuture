package dev.reto.hackthefuture.service.impl;

import dev.reto.hackthefuture.domain.Emisiones;
import dev.reto.hackthefuture.repository.EmisionesRepository;
import dev.reto.hackthefuture.service.EmisionesService;
import dev.reto.hackthefuture.service.dto.EmisionesDTO;
import dev.reto.hackthefuture.service.dto.GenericResponseDTO;
import dev.reto.hackthefuture.service.mapper.EmisionesMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmisionesImpl implements EmisionesService {

    private final EmisionesMapper emisionesMapper;
    private final EmisionesRepository emisionesRepository;

    private final String EMISION_AGREGADA_CORRECTAMENTE = "Emision agregada correctamente";
    private final String REGISTROS_ENCONTRADOS = "Registros encontrados";

    public EmisionesImpl(EmisionesMapper emisionesMapper, EmisionesRepository emisionesRepository) {
        this.emisionesMapper = emisionesMapper;
        this.emisionesRepository = emisionesRepository;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> getEmisionesById(Long pId) {
        List<Emisiones> listEmisiones = emisionesRepository.findEmisionesById(pId);
        List<EmisionesDTO> listDTO = new ArrayList<>();
        for (Emisiones objEmisiones : listEmisiones) {
            listDTO.add(emisionesMapper.toDto(objEmisiones));
        }
        return ResponseEntity.ok().body(new GenericResponseDTO("200", REGISTROS_ENCONTRADOS, listDTO));
    }

    @Override
    public ResponseEntity<GenericResponseDTO> addEmisiones(EmisionesDTO pEmisionesDTO) {
        emisionesRepository.save(emisionesMapper.toEntity(pEmisionesDTO));
        GenericResponseDTO response = new GenericResponseDTO("200", EMISION_AGREGADA_CORRECTAMENTE, null);

        return ResponseEntity.ok().body(response);
    }
}
