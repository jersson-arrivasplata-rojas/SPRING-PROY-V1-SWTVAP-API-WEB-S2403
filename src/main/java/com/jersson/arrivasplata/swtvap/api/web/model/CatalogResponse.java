package com.jersson.arrivasplata.swtvap.api.web.model;

import com.jersson.arrivasplata.swtvap.api.web.enums.Lang;
import com.jersson.arrivasplata.swtvap.api.web.enums.StatusCatalog;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
public class CatalogResponse {
    private Long catalogId;
    private String code;
    private String name;
    private String description;
    private String name_en;
    private String description_en;
    private ArrayList<Category> categories;
    private ArrayList<Product> products;
}
