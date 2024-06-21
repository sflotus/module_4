package org.arthur.case_study.service.main_service;

import org.arthur.case_study.dto.CustomerDTO;
import org.arthur.case_study.model.main_model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(String name,Pageable pageable);
    List<Customer> getList();
    Customer finById(Long id);
    boolean add(Customer customer);
    boolean checkExistPhoneNumber(CustomerDTO customerDTO);
    boolean checkExisIdCard(CustomerDTO customerDTO);
    boolean checkExsitEmail(CustomerDTO customerDTO);

}
