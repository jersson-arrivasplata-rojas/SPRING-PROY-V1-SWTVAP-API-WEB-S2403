package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.Analytic;
import com.jersson.arrivasplata.swtvap.api.web.model.AnalyticRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.AnalyticResponse;
import com.jersson.arrivasplata.swtvap.api.web.model.Analytic;
import com.jersson.arrivasplata.swtvap.api.web.model.AnalyticRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.AnalyticResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnalyticMapper {
    AnalyticMapper INSTANCE = Mappers.getMapper(AnalyticMapper.class);

    //@Mapping(target = "id", ignore = true)
    Analytic analyticRequestToAnalytic(AnalyticRequest analyticRequest);

    AnalyticRequest analyticToAnalyticRequest(Analytic analytic);

    AnalyticResponse analyticToAnalyticResponse(Analytic analytic);

    List<AnalyticResponse> mapAnalyticsToResponses(List<Analytic> analytics);
}
