package org.arthur.case_study.repository.main_repository;

import org.arthur.case_study.model.main_model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Long> {
    @Override
    Page<Contract> findAll(Pageable pageable);
}
