package com.jersson.arrivasplata.swtvap.api.web.model;

import java.time.LocalDate;
import java.util.List;

import com.jersson.arrivasplata.swtvap.api.web.enums.Status;

import lombok.Data;

@Data
public class ParameterResponse {
    private Long id;
    private Long parentId;
    private Long groupId;
    private String description;
    private String value;
    private String value1;
    private String value2;
    private String code;
    private Long position;
    private Status status;
    private LocalDate deletedAt;
    private List<Parameter> children;
}
