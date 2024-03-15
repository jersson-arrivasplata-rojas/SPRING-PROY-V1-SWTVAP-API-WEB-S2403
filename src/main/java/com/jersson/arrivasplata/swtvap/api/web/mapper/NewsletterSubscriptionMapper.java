package com.jersson.arrivasplata.swtvap.api.web.mapper;

import com.jersson.arrivasplata.swtvap.api.web.model.NewsletterSubscription;
import com.jersson.arrivasplata.swtvap.api.web.model.NewsletterSubscriptionRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.NewsletterSubscriptionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewsletterSubscriptionMapper {
    NewsletterSubscriptionMapper INSTANCE = Mappers.getMapper(NewsletterSubscriptionMapper.class);

    //@Mapping(target = "id", ignore = true)
    NewsletterSubscription newsletterSubscriptionRequestToNewsletterSubscription(NewsletterSubscriptionRequest newsletterSubscriptionRequest);

    NewsletterSubscriptionRequest newsletterSubscriptionToNewsletterSubscriptionRequest(NewsletterSubscription newsletterSubscription);

    NewsletterSubscriptionResponse newsletterSubscriptionToNewsletterSubscriptionResponse(NewsletterSubscription newsletterSubscription);

    List<NewsletterSubscriptionResponse> mapNewsletterSubscriptionsToResponses(List<NewsletterSubscription> newsletterSubscriptions);
}
