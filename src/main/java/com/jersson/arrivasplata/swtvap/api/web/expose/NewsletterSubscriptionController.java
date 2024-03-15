package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.NewsletterSubscriptionRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.NewsletterSubscriptionResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NewsletterSubscriptionController {
    Mono<NewsletterSubscriptionResponse> createNewsletterSubscription(NewsletterSubscriptionRequest newsletterSubscriptionRequest);
    // Otros métodos relacionados con newsletterSubscription usando Reactor Core
}
