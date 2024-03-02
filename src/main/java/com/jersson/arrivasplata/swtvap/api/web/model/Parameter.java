package com.jersson.arrivasplata.swtvap.api.web.model;

import java.time.LocalDate;
import java.util.Set;

import com.jersson.arrivasplata.swtvap.api.web.enums.Status;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "swtvap_parameters")
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "group_id")
    private Long groupId;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String value;

    @Column(columnDefinition = "TEXT")
    private String value1;

    @Column(columnDefinition = "TEXT")
    private String value2;

    @Column(length = 50)
    private String code;

    @Column(name = "position")
    private Long position;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

    @OneToMany(mappedBy = "parentId", fetch = FetchType.EAGER)
    private Set<Parameter> children;
}
