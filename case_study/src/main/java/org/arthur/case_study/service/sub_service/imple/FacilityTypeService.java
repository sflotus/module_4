package org.arthur.case_study.service.sub_service.imple;

import org.arthur.case_study.model.sub_model.facility.FacilityType;
import org.arthur.case_study.repository.sub_repository.IFacilityTypeRepository;
import org.arthur.case_study.service.sub_service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    IFacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> getList() {
        return facilityTypeRepository.findAll();
    }
}
