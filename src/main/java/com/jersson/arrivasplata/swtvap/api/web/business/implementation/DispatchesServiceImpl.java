package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jersson.arrivasplata.swtvap.api.web.business.service.DispatchesService;
import com.jersson.arrivasplata.swtvap.api.web.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.web.model.Dispatches;
import com.jersson.arrivasplata.swtvap.api.web.repository.DispatchesRepository;
import com.jersson.arrivasplata.swtvap.api.web.util.Common;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DispatchesServiceImpl implements DispatchesService {
    private final DispatchesRepository dispatchesRepository;

    public DispatchesServiceImpl(DispatchesRepository dispatchesRepository) {
        this.dispatchesRepository = dispatchesRepository;
    }

    public Flux<Dispatches> getAllDispatches() {
        return Flux.fromIterable(dispatchesRepository.findAll());
    }

    public Mono<Dispatches> getDispatchesById(Long id) {
        return Mono.just(dispatchesRepository.findById(id)
                .orElseThrow(() -> new CustomException("Dispatches not found with id: " + id)));
    }

    public Mono<Dispatches> createDispatches(Dispatches dispatches) {
        if (dispatches.getOrderId() == null) {
            throw new CustomException("Order id is required.");
        }
        return Mono.just(dispatchesRepository.save(dispatches));
    }

    public Mono<Dispatches> updateDispatches(Dispatches dispatches) {
        if (dispatches.getOrderId() == null) {
            throw new CustomException("Order id is required.");
        }
        return Mono.just(dispatchesRepository.save(dispatches));
    }

    public Mono<Void> deleteDispatchesById(Long id) {
        Optional<Dispatches> dispatchesOptional = dispatchesRepository.findById(id);
        if (!dispatchesOptional.isPresent()) {
            throw new CustomException("Dispatches not found with id: " + id);
        }
        // Resto de la lógica para eliminar un despacho

        Dispatches dispatches = dispatchesOptional.get();

        dispatches.setDeletedAt(Common.builder().build().getCurrentDate());
        dispatchesRepository.save(dispatches);
        return Mono.empty();
    }


}
