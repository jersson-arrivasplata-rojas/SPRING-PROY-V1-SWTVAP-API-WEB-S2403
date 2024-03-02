package com.jersson.arrivasplata.swtvap.api.web.mapper;

import java.util.List;

import com.jersson.arrivasplata.swtvap.api.web.model.Parameter;
import com.jersson.arrivasplata.swtvap.api.web.model.ParameterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ParameterMapper {
    ParameterMapper INSTANCE = Mappers.getMapper(ParameterMapper.class);

    ParameterResponse toParameterResponse(Parameter parameter);
}
