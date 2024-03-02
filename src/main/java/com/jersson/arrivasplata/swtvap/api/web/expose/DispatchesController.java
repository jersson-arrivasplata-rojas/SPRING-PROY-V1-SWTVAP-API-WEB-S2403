package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.DispatchesRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.DispatchesResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DispatchesController {

    Flux<DispatchesResponse> getAllDispatches();
    Mono<DispatchesResponse> getDispatchesById(Long id);
    Mono<DispatchesResponse> createDispatches(DispatchesRequest dispatchesRequest);
    Mono<DispatchesResponse> updateDispatches(Long id, DispatchesRequest dispatchesRequest);
    Mono<Void> deleteDispatches(Long id);
}
