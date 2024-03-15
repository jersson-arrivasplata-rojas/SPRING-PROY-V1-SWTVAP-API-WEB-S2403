package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.ProductResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductController {

    Flux<ProductResponse> getAllProducts();

    Mono<ProductResponse> getProductByName(String name);
}
