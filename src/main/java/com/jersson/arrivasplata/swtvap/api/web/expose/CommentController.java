package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.CommentRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.CommentResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommentController {
    Mono<CommentResponse> createComment(CommentRequest comment);

}
