package org.arthur.case_study.service.sub_service.imple;

import org.arthur.case_study.model.sub_model.facility.RentType;
import org.arthur.case_study.repository.sub_repository.IRentTypeRepository;
import org.arthur.case_study.service.sub_service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> getList() {
        return rentTypeRepository.findAll();
    }
}
