package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.Category;
import com.jersson.arrivasplata.swtvap.api.web.model.CategoryRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    //@Mapping(target = "id", ignore = true)
    Category categoryRequestToCategory(CategoryRequest categoryRequest);

    CategoryRequest categoryToCategoryRequest(Category category);

    @Mapping(target = "products", expression = "java(new ArrayList<>(category.getProducts()))")
    CategoryResponse categoryToCategoryResponse(Category category);

    List<CategoryResponse> mapCategoriesToResponses(List<Category> categories);
}
