package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.AnalyticService;
import com.jersson.arrivasplata.swtvap.api.web.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.web.model.Analytic;
import com.jersson.arrivasplata.swtvap.api.web.repository.AnalyticRepository;
import com.jersson.arrivasplata.swtvap.api.web.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class AnalyticServiceImpl implements AnalyticService {

    private final AnalyticRepository analyticRepository;

    @Autowired
    public AnalyticServiceImpl(AnalyticRepository analyticRepository) {
        this.analyticRepository = analyticRepository;
    }

    public Mono<Analytic> createAnalytic(Analytic analytic) {
        // Lógica para crear un nuevo analytic
        return Mono.just(analyticRepository.save(analytic));
    }
}