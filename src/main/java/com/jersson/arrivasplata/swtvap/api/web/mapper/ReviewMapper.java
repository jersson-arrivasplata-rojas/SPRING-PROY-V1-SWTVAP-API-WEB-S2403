package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.Review;
import com.jersson.arrivasplata.swtvap.api.web.model.ReviewRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.ReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    //@Mapping(target = "id", ignore = true)
    Review reviewRequestToReview(ReviewRequest reviewRequest);

    ReviewRequest reviewToReviewRequest(Review review);

    ReviewResponse reviewToReviewResponse(Review review);

    List<ReviewResponse> mapReviewsToResponses(List<Review> reviews);
}
