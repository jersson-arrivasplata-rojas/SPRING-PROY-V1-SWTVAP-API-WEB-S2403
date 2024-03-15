package com.jersson.arrivasplata.swtvap.api.web.expose;

import com.jersson.arrivasplata.swtvap.api.web.model.ContactRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.ContactResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ContactController {
    Mono<ContactResponse> createContact(ContactRequest contact);
}
