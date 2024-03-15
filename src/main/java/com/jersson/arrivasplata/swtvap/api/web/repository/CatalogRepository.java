package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.enums.Lang;
import com.jersson.arrivasplata.swtvap.api.web.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {
    // Métodos adicionales para operaciones específicas si son necesarios
    Catalog findByName(String name);

    List<Catalog> findAll();

    List<Catalog> findAllByCode(String code);
}

