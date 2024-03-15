package com.jersson.arrivasplata.swtvap.api.web.repository;


import com.jersson.arrivasplata.swtvap.api.web.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
}
