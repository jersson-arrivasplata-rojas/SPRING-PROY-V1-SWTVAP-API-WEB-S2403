package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.CatalogResponse;
import reactor.core.publisher.Flux;

public interface CatalogController {
    Flux<CatalogResponse> getAllCatalogs();
    Flux<CatalogResponse> getAllCatalogByCode(String code);
    // Otros métodos relacionados con catalogo usando Reactor Core
}
