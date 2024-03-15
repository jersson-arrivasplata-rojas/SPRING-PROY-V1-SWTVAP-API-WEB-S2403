package com.jersson.arrivasplata.swtvap.api.web.model;

import com.jersson.arrivasplata.swtvap.api.web.enums.StatusContact;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ContactResponse {
    private String name;
    private String contact;
    private String email;
    private String details;
}
