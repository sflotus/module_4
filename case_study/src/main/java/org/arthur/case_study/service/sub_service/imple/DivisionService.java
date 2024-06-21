package org.arthur.case_study.service.sub_service.imple;

import org.arthur.case_study.model.sub_model.employee.Division;
import org.arthur.case_study.repository.sub_repository.IDivisionRepository;
import org.arthur.case_study.service.sub_service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    IDivisionRepository divisionRepository;
    @Override
    public List<Division> getList() {
        return divisionRepository.findAll();
    }
}
