package dev.reto.hackthefuture.service.mapper;

import dev.reto.hackthefuture.domain.Emisiones;
import dev.reto.hackthefuture.service.dto.EmisionesDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface EmisionesMapper extends EntityMapper<EmisionesDTO, Emisiones> {}
