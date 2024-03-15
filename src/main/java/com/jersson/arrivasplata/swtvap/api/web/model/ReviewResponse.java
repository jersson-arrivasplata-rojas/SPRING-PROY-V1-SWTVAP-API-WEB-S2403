package com.jersson.arrivasplata.swtvap.api.web.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewResponse {
    private Long productId;
    private Long score;
    private String comment;
    private LocalDate reviewAt;
}
