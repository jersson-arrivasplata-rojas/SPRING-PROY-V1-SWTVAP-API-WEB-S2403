package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.ContactService;
import com.jersson.arrivasplata.swtvap.api.web.expose.ContactController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.ContactMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.Contact;
import com.jersson.arrivasplata.swtvap.api.web.model.ContactRequest;
import com.jersson.arrivasplata.swtvap.api.web.model.ContactResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api/w-contacts", produces = "application/vnd.swtvap-api-w-contacts.v1+json")
public class ContactControllerImpl implements ContactController {
    private final ContactService contactService;
    private final ContactMapper contactMapper;

    public ContactControllerImpl(ContactService contactService, ContactMapper contactMapper) {
        this.contactService = contactService;
        this.contactMapper = contactMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ContactResponse> createContact(@RequestBody ContactRequest contactRequest) {
        Contact contact = contactMapper.contactRequestToContact(contactRequest);

        return Mono.just(contactService.createContact(contact))
                .map(newContact -> {
                    ContactResponse contactResponse = contactMapper.contactToContactResponse(newContact);
                    return contactResponse;
                });
    }

}
