package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.ReviewService;
import com.jersson.arrivasplata.swtvap.api.web.expose.ReviewController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.ReviewMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.Review;
import com.jersson.arrivasplata.swtvap.api.web.model.ReviewRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.ReviewResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api/w-reviews", produces = "application/vnd.swtvap-api-w-reviews.v1+json")
public class ReviewControllerImpl implements ReviewController {
    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    public ReviewControllerImpl(ReviewService reviewService, ReviewMapper reviewMapper) {
        this.reviewService = reviewService;
        this.reviewMapper = reviewMapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ReviewResponse> createReview(@RequestBody ReviewRequest reviewRequest) {
        Review review = reviewMapper.reviewRequestToReview(reviewRequest);

        return Mono.just(reviewService.createReview(review))
                .map(newReview -> {
                    ReviewResponse reviewResponse = reviewMapper.reviewToReviewResponse(newReview);
                    return reviewResponse;
                });
    }

}
