package com.jersson.arrivasplata.swtvap.api.web.business.service;

import com.jersson.arrivasplata.swtvap.api.web.model.Analytic;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AnalyticService {
    Mono<Analytic> createAnalytic(Analytic analytic);
    // Otros métodos relacionados con producto usando Reactor Core
}
