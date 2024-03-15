package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.AnalyticService;
import com.jersson.arrivasplata.swtvap.api.web.expose.AnalyticController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.AnalyticMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.Analytic;
import com.jersson.arrivasplata.swtvap.api.web.model.AnalyticRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.AnalyticResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/w-analytics", produces = "application/vnd.swtvap-api-w-analytics.v1+json")
public class AnalyticControllerImpl implements AnalyticController {
    private final AnalyticService analyticService;
    private final AnalyticMapper analyticMapper;


    public AnalyticControllerImpl(AnalyticService analyticService, AnalyticMapper analyticMapper) {
        this.analyticService = analyticService;
        this.analyticMapper = analyticMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AnalyticResponse> createAnalytic(@RequestBody AnalyticRequest analyticRequest) {
        Analytic analytic = analyticMapper.analyticRequestToAnalytic(analyticRequest);

        return analyticService.createAnalytic(analytic)
                .map(newAnalytic -> {
                    AnalyticResponse analyticResponse = analyticMapper.analyticToAnalyticResponse(newAnalytic);
                    return analyticResponse;
                });
    }

    // Implementa otros métodos del controlador si es necesario
}