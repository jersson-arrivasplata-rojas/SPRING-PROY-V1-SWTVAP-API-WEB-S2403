package com.jersson.arrivasplata.swtvap.api.web.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.jersson.arrivasplata.swtvap.api.web.enums.Status;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "swtvap_dispatches")
public class Dispatches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nullable()
    @Column(name = "order_id", nullable = true)
    private Long orderId;

    @Nullable()
    @Column(name = "provider_id", nullable = true)
    private Long providerId;

    @Column(precision = 10, scale = 2)
    private BigDecimal cost;

    @Column(name = "type_currency", length = 10)
    private String typeCurrency;

    private Timestamp date;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(columnDefinition = "TEXT")
    private String otherDetails;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @OneToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Provider provider;
/*
    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Order> order;
*/
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

}
