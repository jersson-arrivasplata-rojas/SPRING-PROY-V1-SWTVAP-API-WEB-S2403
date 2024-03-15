package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.CommentService;
import com.jersson.arrivasplata.swtvap.api.web.expose.CommentController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.CommentMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.Comment;
import com.jersson.arrivasplata.swtvap.api.web.model.CommentRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.CommentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api/w-comments", produces = "application/vnd.swtvap-api-w-comments.v1+json")
public class CommentControllerImpl implements CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    public CommentControllerImpl(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CommentResponse> createComment(@RequestBody CommentRequest commentRequest) {
        Comment comment = commentMapper.commentRequestToComment(commentRequest);

        return Mono.just(commentService.createComment(comment))
                .map(newComment -> {
                    CommentResponse commentResponse = commentMapper.commentToCommentResponse(newComment);
                    return commentResponse;
                });
    }

}
