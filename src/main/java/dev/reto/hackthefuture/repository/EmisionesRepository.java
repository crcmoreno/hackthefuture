package dev.reto.hackthefuture.repository;

import dev.reto.hackthefuture.domain.Emisiones;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmisionesRepository extends CrudRepository<Emisiones, Long> {
    @Query(value = "SELECT * FROM clkdata.emisiones WHERE emision_id = :id", nativeQuery = true)
    List<Emisiones> findEmisionesById(@Param("id") Long pId);
}
