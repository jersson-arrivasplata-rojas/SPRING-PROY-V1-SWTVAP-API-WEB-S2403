package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.Catalog;
import com.jersson.arrivasplata.swtvap.api.web.model.CatalogRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.CatalogResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatalogMapper {
    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

    //@Mapping(target = "id", ignore = true)
    Catalog catalogRequestToCatalog(CatalogRequest catalogRequest);

    CatalogRequest catalogToCatalogRequest(Catalog catalog);

    @Mapping(target = "categories", expression = "java(new ArrayList<>(catalog.getCategories()))")
    CatalogResponse catalogToCatalogResponse(Catalog catalog);

    List<CatalogResponse> mapCatalogsToResponses(List<Catalog> catalogs);
}
