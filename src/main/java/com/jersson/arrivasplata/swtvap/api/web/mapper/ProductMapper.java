package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.Product;
import com.jersson.arrivasplata.swtvap.api.web.model.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "deletedAt", ignore = true)
    ProductResponse toProductResponse(Product product);

    //@Mapping(target = "productImages", expression = "java(new ArrayList<>(product.getProductImages()))")
    @Mapping(target = "comments", expression = "java(new ArrayList<>(product.getProductComments()))")
    @Mapping(target = "parameters", expression = "java(new ArrayList<>(product.getParameters()))")
    @Mapping(target = "discounts", expression = "java(new ArrayList<>(product.getProductDiscounts()))")
    @Mapping(target = "images", expression = "java(new ArrayList<>(product.getProductImages()))")
    @Mapping(target = "units", expression = "java(new ArrayList<>(product.getUnits()))")
    @Mapping(target = "deletedAt", ignore = true)
    ProductResponse productToProductResponse(Product product);
}
