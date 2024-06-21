package org.arthur.case_study.repository.main_repository;

import org.arthur.case_study.model.main_model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Long> {
    Page<Facility> findAllByNameContaining(String name,Pageable pageable);
}
