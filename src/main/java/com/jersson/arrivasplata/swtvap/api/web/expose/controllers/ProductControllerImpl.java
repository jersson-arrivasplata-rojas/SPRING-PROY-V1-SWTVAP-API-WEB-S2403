package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.ProductService;
import com.jersson.arrivasplata.swtvap.api.web.expose.ProductController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.ProductMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api/w-products", produces = "application/vnd.swtvap-api-w-products.v1+json")
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;


    public ProductControllerImpl(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ProductResponse> getAllProducts() {
        return productService.getAllProducts()
                .map(product -> {
                    ProductResponse productResponse = productMapper.productToProductResponse(product);
                    return productResponse;
                });
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ProductResponse> getProductByName(@PathVariable String name) {
        return Mono.just(name)
                .flatMap(productService::getProductByName)
                .map(product -> {
                    ProductResponse productResponse = productMapper.productToProductResponse(product);
                    return productResponse;
                });
    }
}
