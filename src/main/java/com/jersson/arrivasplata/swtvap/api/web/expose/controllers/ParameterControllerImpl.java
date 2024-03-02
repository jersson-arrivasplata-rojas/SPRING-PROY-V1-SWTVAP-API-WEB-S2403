package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;
import com.jersson.arrivasplata.swtvap.api.web.mapper.ParameterMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.Parameter;
import com.jersson.arrivasplata.swtvap.api.web.model.ParameterResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.jersson.arrivasplata.swtvap.api.web.business.service.ParameterService;
import com.jersson.arrivasplata.swtvap.api.web.expose.ParameterController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api/w-parameters", produces = "application/vnd.swtvap-api-w-parameters.v1+json")
public class ParameterControllerImpl implements ParameterController {
    private final ParameterService parameterService;
    private final ParameterMapper parameterMapper;


    public ParameterControllerImpl(ParameterService parameterService, ParameterMapper parameterMapper) {
        this.parameterService = parameterService;
        this.parameterMapper = parameterMapper;
    }

    @GetMapping("/code/{code}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ParameterResponse> getStructureByCode(@PathVariable String code) {
        return Mono.just(parameterService.getStructureByCode(code))
                .map(parameterMapper::toParameterResponse);
    }
}
