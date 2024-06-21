package org.arthur.case_study.repository.main_repository;

import org.arthur.case_study.model.main_model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

    Page<Employee> findAllByNameContaining(String name,Pageable pageable);
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByIdCard(String id);
    boolean existsByEmail(String email);
}
