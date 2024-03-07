package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;
import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jersson.arrivasplata.swtvap.api.web.business.service.ParameterService;
import com.jersson.arrivasplata.swtvap.api.web.expose.ParameterController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.ParameterMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.ParameterResponse;

import reactor.core.publisher.Flux;
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

    @GetMapping("/code/{codes}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ParameterResponse> getStructureByCode(@PathVariable String codes) {
        String[] codesArray = codes.split(",");
        return Flux.fromArray(codesArray)
                .flatMap(code -> Mono.just(parameterService.getStructureByCode(code))
                        .map(data -> parameterMapper.toParameterResponse(data))
                );
    }
}
