package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;



import com.jersson.arrivasplata.swtvap.api.web.business.service.CatalogService;
import com.jersson.arrivasplata.swtvap.api.web.expose.CatalogController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.CatalogMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.CatalogResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/w-catalogs", produces = "application/vnd.swtvap-api-w-catalogs.v1+json")
public class CatalogControllerImpl implements CatalogController {
    private final CatalogService catalogService;
    private final CatalogMapper catalogMapper;


    public CatalogControllerImpl(CatalogService catalogService, CatalogMapper catalogMapper) {
        this.catalogService = catalogService;
        this.catalogMapper = catalogMapper;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Flux<CatalogResponse> getAllCatalogs() {
        return catalogService.getAllCatalogs()
                .map(catalog -> {
                    CatalogResponse catalogResponse = catalogMapper.catalogToCatalogResponse(catalog);
                    return catalogResponse;
                });
    }

    @GetMapping(value = "/code/{code}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CatalogResponse> getAllCatalogByCode(@PathVariable("code") String code) {
        return catalogService.getAllCatalogByCode(code)
                .map(catalog -> {
                    CatalogResponse catalogResponse = catalogMapper.catalogToCatalogResponse(catalog);
                    return catalogResponse;
                });
    }

}