package com.jersson.arrivasplata.swtvap.api.web.repository;

import com.jersson.arrivasplata.swtvap.api.web.model.Dispatches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatchesRepository extends JpaRepository<Dispatches,Long> {

    Dispatches findById(String id);
}
