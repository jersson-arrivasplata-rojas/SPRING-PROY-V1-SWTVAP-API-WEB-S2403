package com.jersson.arrivasplata.swtvap.api.web.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AnalyticResponse {

    private String visitedPage;
    private LocalDate visitedDate;
}