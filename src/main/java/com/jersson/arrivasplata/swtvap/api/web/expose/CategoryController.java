package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.CategoryResponse;
import reactor.core.publisher.Flux;

public interface CategoryController {
    Flux<CategoryResponse> getAllCategories();
    // Otros métodos relacionados con catalogo usando Reactor Core
}
