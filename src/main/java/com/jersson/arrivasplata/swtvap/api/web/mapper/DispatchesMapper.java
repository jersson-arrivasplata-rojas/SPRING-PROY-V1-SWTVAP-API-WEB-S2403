package com.jersson.arrivasplata.swtvap.api.web.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.jersson.arrivasplata.swtvap.api.web.model.Dispatches;
import com.jersson.arrivasplata.swtvap.api.web.model.DispatchesRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.DispatchesResponse;

@Mapper(componentModel = "spring")

public interface DispatchesMapper {
    DispatchesMapper INSTANCE = Mappers.getMapper(DispatchesMapper.class);
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "providerId", target = "providerId")
    @Mapping(source = "cost", target = "cost")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "otherDetails", target = "otherDetails")
    Dispatches dispatchesRequestToDispatches(DispatchesRequest dispatchesRequest);

    DispatchesRequest dispatchesToDispatchesRequest(Dispatches dispatches);
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "providerId", target = "providerId")
    @Mapping(source = "cost", target = "cost")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "otherDetails", target = "otherDetails")
    DispatchesResponse dispatchesToDispatchesResponse(Dispatches dispatches);

    List<DispatchesResponse> mapDispatchesToResponses(List<Dispatches> dispatches);
}
