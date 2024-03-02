package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.ParameterResponse;
import reactor.core.publisher.Mono;

public interface ParameterController {

    Mono<ParameterResponse> getStructureByCode(String code);
}
