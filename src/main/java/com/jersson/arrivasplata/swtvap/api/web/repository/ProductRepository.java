package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import com.jersson.arrivasplata.swtvap.api.web.model.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Long> {

    //@Query("SELECT p FROM Product p JOIN FETCH p.productImages JOIN FETCH p.units WHERE p.name = :name AND p.status = :status AND p.deletedAt IS NULL")
    Product findByNameAndStatusAndDeletedAtIsNull(String name, Status status);

    Product findByNameEnAndStatusAndDeletedAtIsNull(String nameEn, Status status);

}
