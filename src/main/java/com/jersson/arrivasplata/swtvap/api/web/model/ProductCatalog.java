package com.jersson.arrivasplata.swtvap.api.web.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@Entity
@Table(name = "swtvap_products_catalogs")
public class ProductCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;
}
