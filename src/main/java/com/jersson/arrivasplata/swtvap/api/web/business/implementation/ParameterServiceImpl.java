package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.jersson.arrivasplata.swtvap.api.web.model.Parameter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jersson.arrivasplata.swtvap.api.web.business.service.ParameterService;
import com.jersson.arrivasplata.swtvap.api.web.repository.ParameterRepository;

@Service
public class ParameterServiceImpl implements ParameterService {
    private final ParameterRepository parameterRepository;

    @Autowired
    public ParameterServiceImpl(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    public Parameter getStructureByCode(String code) {
        Optional<Parameter> root = parameterRepository.findByCode(code).stream().findFirst();
        if(root.isPresent()) {
            addChildrenRecursive(root.get());
        }
        return root.orElse(null);
    }

    private void addChildrenRecursive(Parameter parent) {
        List<Parameter> children = parameterRepository.findByParentId(parent.getId());
        parent.setChildren(new HashSet<>(children));
        for(Parameter child : children) {
            addChildrenRecursive(child);
        }
    }
}
