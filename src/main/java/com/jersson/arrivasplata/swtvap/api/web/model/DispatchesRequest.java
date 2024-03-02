package com.jersson.arrivasplata.swtvap.api.web.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.jersson.arrivasplata.swtvap.api.web.enums.Status;

import lombok.Data;

@Data
public class DispatchesRequest {
    private Long id;
    private Long orderId;
    private Long providerId;
    private BigDecimal cost;
    private String typeCurrency;
    private Timestamp date;
    private Status status;
    private String otherDetails;
    private LocalDate deletedAt;

}
