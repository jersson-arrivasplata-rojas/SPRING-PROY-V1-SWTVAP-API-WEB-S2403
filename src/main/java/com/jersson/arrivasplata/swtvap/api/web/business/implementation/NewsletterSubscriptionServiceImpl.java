package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.NewsletterSubscriptionService;
import com.jersson.arrivasplata.swtvap.api.web.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.web.model.NewsletterSubscription;
import com.jersson.arrivasplata.swtvap.api.web.repository.NewsletterSubscriptionRepository;
import com.jersson.arrivasplata.swtvap.api.web.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class NewsletterSubscriptionServiceImpl implements NewsletterSubscriptionService {

    private final NewsletterSubscriptionRepository newsletterSubscriptionRepository;

    @Autowired
    public NewsletterSubscriptionServiceImpl(NewsletterSubscriptionRepository newsletterSubscriptionRepository) {
        this.newsletterSubscriptionRepository = newsletterSubscriptionRepository;
    }

    public Mono<NewsletterSubscription> createNewsletterSubscription(NewsletterSubscription newsletterSubscription) {
        // Lógica para crear un nuevo newsletterSubscription
        return Mono.just(newsletterSubscriptionRepository.save(newsletterSubscription));
    }
}