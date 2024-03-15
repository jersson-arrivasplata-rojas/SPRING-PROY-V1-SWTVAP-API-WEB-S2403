package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.CatalogService;
import com.jersson.arrivasplata.swtvap.api.web.enums.Lang;
import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import com.jersson.arrivasplata.swtvap.api.web.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.web.model.Catalog;
import com.jersson.arrivasplata.swtvap.api.web.model.Category;
import com.jersson.arrivasplata.swtvap.api.web.model.Product;
import com.jersson.arrivasplata.swtvap.api.web.model.ProductCatalog;
import com.jersson.arrivasplata.swtvap.api.web.repository.CatalogRepository;
import com.jersson.arrivasplata.swtvap.api.web.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Flux<Catalog> getAllCatalogs() {
        return Flux.fromIterable(catalogRepository.findAll())////Lang.valueOf(lang.toUpperCase())
                .filter(catalog -> Status.ACTIVE.name().equals(catalog.getStatus().name()) && catalog.getDeletedAt() == null)
                .map(catalog -> {

                    List<Product> filteredProducts = catalog.getProducts().stream()
                            .filter(product -> product.getStatus() == Status.ACTIVE && product.getDeletedAt() == null)
                            .map(productCatalog -> Common.builder().build().filterProduct(productCatalog))
                            .collect(Collectors.toList());
                    catalog.setProducts(new HashSet<>(filteredProducts));

                    List<Category> filteredCategories = catalog.getCategories().stream()
                            .filter(category -> category.getStatus() == Status.ACTIVE && category.getDeletedAt() == null)
                            .map(category -> {
                                List<Product> filteredCategoryProducts = category.getProducts().stream()
                                        .filter(product -> product.getStatus() == Status.ACTIVE && product.getDeletedAt() == null)
                                        .map(product -> Common.builder().build().filterProduct(product))
                                        .collect(Collectors.toList());
                                category.setProducts(new HashSet<>(filteredCategoryProducts));
                                return category;
                            })
                            .collect(Collectors.toList());
                    catalog.setCategories(new HashSet<>(filteredCategories));

                    return catalog;
                })
                .switchIfEmpty(Mono.error(new CustomException("Catalog not found")));
    }


    @Override
    public Flux<Catalog> getAllCatalogByCode(String code) {
        return Flux.fromIterable(catalogRepository.findAllByCode(code))
                .filter(catalog -> Status.ACTIVE.name().equals(catalog.getStatus().name()) && catalog.getDeletedAt() == null)
                .map(catalog -> {

                    List<Product> filteredProducts = catalog.getProducts().stream()
                            .filter(product -> product.getStatus() == Status.ACTIVE && product.getDeletedAt() == null)
                            .map(productCatalog -> Common.builder().build().filterProduct(productCatalog))
                            .collect(Collectors.toList());
                    catalog.setProducts(new HashSet<>(filteredProducts));

                    List<Category> filteredCategories = catalog.getCategories().stream()
                            .filter(category -> category.getStatus() == Status.ACTIVE && category.getDeletedAt() == null)
                            .map(category -> {
                                List<Product> filteredCategoryProducts = category.getProducts().stream()
                                        .filter(product -> product.getStatus() == Status.ACTIVE && product.getDeletedAt() == null)
                                        .map(product -> Common.builder().build().filterProduct(product))
                                        .collect(Collectors.toList());
                                category.setProducts(new HashSet<>(filteredCategoryProducts));
                                return category;
                            })
                            .collect(Collectors.toList());
                    catalog.setCategories(new HashSet<>(filteredCategories));

                    return catalog;
                })
                .switchIfEmpty(Mono.error(new CustomException("Catalog not found with code: " + code)));
    }
}