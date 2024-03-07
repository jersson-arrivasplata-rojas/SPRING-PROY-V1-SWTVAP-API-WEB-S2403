package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.ParameterResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParameterController {

    Flux<ParameterResponse> getStructureByCode(String code);
}
