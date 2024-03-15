package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.NewsletterSubscriptionService;
import com.jersson.arrivasplata.swtvap.api.web.expose.NewsletterSubscriptionController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.NewsletterSubscriptionMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.NewsletterSubscription;
import com.jersson.arrivasplata.swtvap.api.web.model.NewsletterSubscriptionRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.NewsletterSubscriptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/w-newsletter-subscriptions", produces = "application/vnd.swtvap-api-w-newsletter-subscriptions.v1+json")
public class NewsletterSubscriptionControllerImpl implements NewsletterSubscriptionController {
    private final NewsletterSubscriptionService newsletterSubscriptionService;
    private final NewsletterSubscriptionMapper newsletterSubscriptionMapper;


    public NewsletterSubscriptionControllerImpl(NewsletterSubscriptionService newsletterSubscriptionService, NewsletterSubscriptionMapper newsletterSubscriptionMapper) {
        this.newsletterSubscriptionService = newsletterSubscriptionService;
        this.newsletterSubscriptionMapper = newsletterSubscriptionMapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<NewsletterSubscriptionResponse> createNewsletterSubscription(@RequestBody NewsletterSubscriptionRequest newsletterSubscriptionRequest) {
        NewsletterSubscription newsletterSubscription = newsletterSubscriptionMapper.newsletterSubscriptionRequestToNewsletterSubscription(newsletterSubscriptionRequest);

        return newsletterSubscriptionService.createNewsletterSubscription(newsletterSubscription)
                .map(newNewsletterSubscription -> {
                    NewsletterSubscriptionResponse newsletterSubscriptionResponse = newsletterSubscriptionMapper.newsletterSubscriptionToNewsletterSubscriptionResponse(newNewsletterSubscription);
                    return newsletterSubscriptionResponse;
                });
    }


    // Implementa otros métodos del controlador si es necesario
}