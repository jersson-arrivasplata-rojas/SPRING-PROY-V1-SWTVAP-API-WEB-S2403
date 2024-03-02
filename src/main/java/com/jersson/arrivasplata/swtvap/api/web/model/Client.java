package com.jersson.arrivasplata.swtvap.api.web.model;

import java.time.LocalDate;

import com.jersson.arrivasplata.swtvap.api.web.enums.SourceAggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "swtvap_clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long clientId;

    @Column(length = 50)
    private String name;

    @Column(length = 250)
    private String address;

    @Column(length = 20)
    private String phone;

    @Column(length = 20)
    private String cellphone;

    @Column(name="country_code", length = 5)
    private String countryCode;

    @Column(length = 50)
    private String email;

    @Column()
    private Boolean whatsapp;

    @Column(length = 250)
    private String details;

    @Column(name="other_details", columnDefinition = "TEXT")
    private String otherDetails;

    @Enumerated(EnumType.ORDINAL)
    private SourceAggregate sourceAggregate;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;
}
