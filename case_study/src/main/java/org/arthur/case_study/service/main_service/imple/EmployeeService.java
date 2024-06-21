package org.arthur.case_study.service.main_service.imple;

import org.arthur.case_study.dto.EmployeeDTO;
import org.arthur.case_study.model.main_model.Contract;
import org.arthur.case_study.model.main_model.Employee;
import org.arthur.case_study.repository.main_repository.IEmployeeRepository;
import org.arthur.case_study.service.main_service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(String name,Pageable pageable) {
        return employeeRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public List<Employee> getList() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean add(Employee employee) {
      try{
          employeeRepository.save(employee);
      }
      catch (Exception e){
          return false;
      }
      return true;
    }

    @Override
    public boolean checkExistPhoneNumber(EmployeeDTO employeeDTO) {
        if(employeeDTO.getId()==null){
            return employeeRepository.existsByPhoneNumber(employeeDTO.getPhoneNumber());
        } else {
            return Objects.equals(finById(employeeDTO.getId()).getPhoneNumber(), employeeDTO.getPhoneNumber());
        }
    }

    @Override
    public boolean checkExistIdCard(EmployeeDTO employeeDTO) {
        if(employeeDTO.getId()==null){
            return employeeRepository.existsByIdCard(employeeDTO.getIdCard());
        } else {
            return Objects.equals(finById(employeeDTO.getId()).getIdCard(), employeeDTO.getIdCard());
        }
    }

    @Override
    public boolean checkExistEmail(EmployeeDTO employeeDTO) {
        if(employeeDTO.getId()==null){
            return employeeRepository.existsByEmail(employeeDTO.getEmail());
        } else {
            return Objects.equals(finById(employeeDTO.getId()).getEmail(), employeeDTO.getEmail());
        }
    }

    @Override
    public Employee finById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
