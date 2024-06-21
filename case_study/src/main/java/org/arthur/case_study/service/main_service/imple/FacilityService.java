package org.arthur.case_study.service.main_service.imple;

import org.arthur.case_study.model.main_model.Facility;
import org.arthur.case_study.repository.main_repository.IFacilityRepository;
import org.arthur.case_study.service.main_service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(String name,Pageable pageable) {
        return facilityRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public List<Facility> getList() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility finById(Long id) {
        return facilityRepository.findById(id).orElse(null);

    }

    @Override
    public boolean add(Facility facility) {
        try{
            facilityRepository.save(facility);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
