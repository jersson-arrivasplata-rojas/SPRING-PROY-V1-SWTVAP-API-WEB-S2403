package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.ParameterService;
import com.jersson.arrivasplata.swtvap.api.web.business.service.ProductService;
import com.jersson.arrivasplata.swtvap.api.web.enums.Lang;
import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import com.jersson.arrivasplata.swtvap.api.web.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.web.model.*;
import com.jersson.arrivasplata.swtvap.api.web.repository.ParameterRepository;
import com.jersson.arrivasplata.swtvap.api.web.repository.ProductRepository;
import com.jersson.arrivasplata.swtvap.api.web.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> getAllProducts() {
        return Flux.fromIterable(productRepository.findAll());
    }

    public Mono<Product> getProductByName(String name, String lang) {
        Product product = new Product();
        if(Lang.valueOf(lang) == Lang.ES){
            product = productRepository.findByNameAndStatusAndDeletedAtIsNull(name, Status.ACTIVE);
        }else if(Lang.valueOf(lang) == Lang.EN){
            product = productRepository.findByNameEnAndStatusAndDeletedAtIsNull(name, Status.ACTIVE);
        }

        return Mono.just(product)
                .flatMap(response -> {
                    if (response == null) {
                        return Mono.error(new CustomException("Product not found with name: " + name));
                    }

                    Product productFilter = Common.builder().build().filterProduct(response);

                    return Mono.just(productFilter);
                });
    }
}
