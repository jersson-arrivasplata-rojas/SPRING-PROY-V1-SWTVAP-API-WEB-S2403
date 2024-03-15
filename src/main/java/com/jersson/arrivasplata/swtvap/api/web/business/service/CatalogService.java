package com.jersson.arrivasplata.swtvap.api.web.business.service;

import com.jersson.arrivasplata.swtvap.api.web.model.Catalog;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CatalogService {
    Flux<Catalog> getAllCatalogs();
    Flux<Catalog> getAllCatalogByCode(String code);
}
