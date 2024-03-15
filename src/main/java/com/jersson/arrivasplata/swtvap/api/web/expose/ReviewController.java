package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.ReviewRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.ReviewResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReviewController {
    Mono<ReviewResponse> createReview(ReviewRequest review);

}
