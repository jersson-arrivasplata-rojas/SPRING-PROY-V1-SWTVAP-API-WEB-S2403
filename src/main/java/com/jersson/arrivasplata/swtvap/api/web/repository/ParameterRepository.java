package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.model.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParameterRepository extends JpaRepository<Parameter,Long> {
    List<Parameter> findByCode(String code);

    List<Parameter> findByParentId(Long parentId);

}
