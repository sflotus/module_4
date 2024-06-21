package org.arthur.case_study.repository.sub_repository;

import org.arthur.case_study.model.sub_model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends JpaRepository<Position,Long> {
}
