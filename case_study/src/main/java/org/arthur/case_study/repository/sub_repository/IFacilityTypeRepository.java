package org.arthur.case_study.repository.sub_repository;

import org.arthur.case_study.model.sub_model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Long> {
}
