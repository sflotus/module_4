package org.arthur.case_study.repository.main_repository;

import org.arthur.case_study.model.main_model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findCustomerByNameContaining(String name,Pageable pageable);
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByIdCard(String id);
    boolean existsByEmail(String email);
}
