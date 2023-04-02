package dev.reto.hackthefuture.web.rest;

import dev.reto.hackthefuture.service.EmisionesService;
import dev.reto.hackthefuture.service.dto.GenericResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing users.
 * <p>
 * This class accesses the {@link dev.reto.hackthefuture.domain.User} entity, and needs to fetch its collection of authorities.
 * <p>
 * For a normal use-case, it would be better to have an eager relationship between User and Authority,
 * and send everything to the client side: there would be no View Model and DTO, a lot less code, and an outer-join
 * which would be good for performance.
 * <p>
 * We use a View Model and a DTO for 3 reasons:
 * <ul>
 * <li>We want to keep a lazy association between the user and the authorities, because people will
 * quite often do relationships with the user, and we don't want them to get the authorities all
 * the time for nothing (for performance reasons). This is the #1 goal: we should not impact our users'
 * application because of this use-case.</li>
 * <li> Not having an outer join causes n+1 requests to the database. This is not a real issue as
 * we have by default a second-level cache. This means on the first HTTP call we do the n+1 requests,
 * but then all authorities come from the cache, so in fact it's much better than doing an outer join
 * (which will get lots of data from the database, for each HTTP call).</li>
 * <li> As this manages users, for security reasons, we'd rather have a DTO layer.</li>
 * </ul>
 * <p>
 * Another option would be to have a specific JPA entity graph to handle this case.
 */
@RestController
@RequestMapping("/api")
public class GetApis {

    private final Logger log = LoggerFactory.getLogger(GetApis.class);

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private EmisionesService emisionesService;

    public GetApis(EmisionesService emisionesService) {
        this.emisionesService = emisionesService;
    }

    @GetMapping("/open/hello/{name}")
    public ResponseEntity<String> getHello(@PathVariable("name") String pName) {
        log.debug("REST request to get greting : {}", pName);
        return new ResponseEntity<>(String.format("Hello: %s", pName), HttpStatus.OK);
    }

    @GetMapping("/open/get/emisiones/{id}")
    public ResponseEntity<GenericResponseDTO> getcombustibleById(@PathVariable("id") Long pId) {
        return emisionesService.getEmisionesById(pId);
    }
}
