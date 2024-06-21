package org.arthur.case_study.service.main_service;

import org.arthur.case_study.dto.EmployeeDTO;
import org.arthur.case_study.model.main_model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(String name,Pageable pageable);
    List<Employee> getList();
    boolean add(Employee employee);
    boolean checkExistPhoneNumber(EmployeeDTO employeeDTO);
    boolean checkExistIdCard(EmployeeDTO employeeDTO);
    boolean checkExistEmail(EmployeeDTO employeeDTO);
    Employee finById(Long id);

}
