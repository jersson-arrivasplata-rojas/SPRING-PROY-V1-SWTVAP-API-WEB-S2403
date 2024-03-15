package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.AnalyticRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.AnalyticResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AnalyticController {
    Mono<AnalyticResponse> createAnalytic(AnalyticRequest analyticRequest);
    // Otros métodos relacionados con analytico usando Reactor Core
}
