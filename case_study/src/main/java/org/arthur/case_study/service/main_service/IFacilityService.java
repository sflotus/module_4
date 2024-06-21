package org.arthur.case_study.service.main_service;

import org.arthur.case_study.model.main_model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAll(String name,Pageable pageable);
    List<Facility> getList();
    Facility finById(Long id);
    boolean add(Facility facility);
}
