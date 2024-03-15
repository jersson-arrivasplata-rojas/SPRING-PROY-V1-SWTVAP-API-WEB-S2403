package com.jersson.arrivasplata.swtvap.api.web.business.service;

import com.jersson.arrivasplata.swtvap.api.web.model.NewsletterSubscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NewsletterSubscriptionService {
    Mono<NewsletterSubscription> createNewsletterSubscription(NewsletterSubscription newsletterSubscription);
    // Otros métodos relacionados con producto usando Reactor Core
}
