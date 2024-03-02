package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jersson.arrivasplata.swtvap.api.web.business.service.DispatchesService;
import com.jersson.arrivasplata.swtvap.api.web.expose.DispatchesController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.DispatchesMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.Dispatches;
import com.jersson.arrivasplata.swtvap.api.web.model.DispatchesRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.DispatchesResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/dispatches", produces = "application/vnd.swtvap-api-dispatches.v1+json")
public class DispatchesControllerImpl implements DispatchesController{
    private final DispatchesService dispatchesService;
    private final DispatchesMapper dispatchesMapper;


    public DispatchesControllerImpl(DispatchesService dispatchesService, DispatchesMapper dispatchesMapper) {
        this.dispatchesService = dispatchesService;
        this.dispatchesMapper = dispatchesMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<DispatchesResponse> getAllDispatches() {
        return dispatchesService.getAllDispatches()
                .map(dispatches -> {
                    DispatchesResponse dispatchesResponse = dispatchesMapper.dispatchesToDispatchesResponse(dispatches);
                    return dispatchesResponse;
                });
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DispatchesResponse> getDispatchesById(@PathVariable Long id) {
        return dispatchesService.getDispatchesById(id)
                .map(dispatches -> {
                    DispatchesResponse dispatchesResponse = dispatchesMapper.dispatchesToDispatchesResponse(dispatches);
                    return dispatchesResponse;
                });
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<DispatchesResponse> createDispatches(@RequestBody DispatchesRequest dispatchesRequest) {
        Dispatches dispatches = dispatchesMapper.dispatchesRequestToDispatches(dispatchesRequest);

        return dispatchesService.createDispatches(dispatches)
                .map(newDispatches -> {
                    DispatchesResponse dispatchesResponse = dispatchesMapper.dispatchesToDispatchesResponse(newDispatches);
                    return dispatchesResponse;
                });
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DispatchesResponse> updateDispatches(@PathVariable Long id, @RequestBody DispatchesRequest dispatchesRequest) {
        Dispatches dispatches = dispatchesMapper.dispatchesRequestToDispatches(dispatchesRequest);
        dispatches.setId(id);
        return dispatchesService.updateDispatches(dispatches)
                .map(updatedDispatches -> {
                    DispatchesResponse dispatchesResponse = dispatchesMapper.dispatchesToDispatchesResponse(updatedDispatches);
                    return dispatchesResponse;
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteDispatches(@PathVariable Long id) {
        return dispatchesService.deleteDispatchesById(id);

    }
}
