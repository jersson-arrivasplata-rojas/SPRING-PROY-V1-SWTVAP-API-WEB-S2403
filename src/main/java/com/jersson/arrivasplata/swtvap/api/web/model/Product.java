package com.jersson.arrivasplata.swtvap.api.web.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jersson.arrivasplata.swtvap.api.web.enums.Status;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@Table(name = "swtvap_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productId;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "name", length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "name_en", length = 200)
    private String name_en;

    @Column(columnDefinition = "TEXT")
    private String description_en;

    @Column(name = "price", precision = 50, scale = 10)
    private BigDecimal price;

    @Column(name = "priceUSD", precision = 50, scale = 10)
    private BigDecimal priceUSD;

    @Column(name = "priceEUR", precision = 50, scale = 10)
    private BigDecimal priceEUR;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "stock_min")
    private Long stockMin;

    @Column(columnDefinition = "TEXT")
    private String otherDetails;

    @Column(columnDefinition = "TEXT")
    private String otherDetails_en;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;


    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private Set<Catalog> catalogs = new HashSet<>();

    /*@ManyToMany(mappedBy = "products")
    @JsonBackReference
    private Set<Category> categories = new HashSet<>();*/

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "swtvap_products_units",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "unit_id"))
    @JsonManagedReference
    private Set<Unit> units = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "swtvap_products_parameters",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "parameter_id"))
    @JsonManagedReference
    private Set<ParameterProduct> parameters = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProductImage> productImages = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProductDiscount> productDiscounts = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> productComments = new ArrayList<>();
}