package org.arthur.case_study.service.main_service.imple;

import org.arthur.case_study.dto.CustomerDTO;
import org.arthur.case_study.model.main_model.Customer;
import org.arthur.case_study.repository.main_repository.ICustomerRepository;
import org.arthur.case_study.service.main_service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(String name,Pageable pageable) {
        return customerRepository.findCustomerByNameContaining(name,pageable);
    }

    @Override
    public List<Customer> getList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer finById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public boolean add(Customer customer) {
        try{
            customerRepository.save(customer);
        }
        catch (Exception e){
            return  false;
        }
        return true;
    }

    @Override
    public boolean checkExistPhoneNumber(CustomerDTO customerDTO) {
        if(customerDTO.getId()==null){
            return customerRepository.existsByPhoneNumber(customerDTO.getPhoneNumber());
        } else {
            return Objects.equals(finById(customerDTO.getId()).getPhoneNumber(), customerDTO.getPhoneNumber());
        }
    }

    @Override
    public boolean checkExisIdCard(CustomerDTO customerDTO) {
        if(customerDTO.getId()==null){
            return customerRepository.existsByIdCard(customerDTO.getIdCard());
        } else {
            return Objects.equals(finById(customerDTO.getId()).getIdCard(), customerDTO.getIdCard());
        }
    }

    @Override
    public boolean checkExsitEmail(CustomerDTO customerDTO) {
        if(customerDTO.getId()==null){
            return customerRepository.existsByEmail(customerDTO.getEmail());
        } else {
            return Objects.equals(finById(customerDTO.getId()).getEmail(), customerDTO.getEmail());
        }
    }
}
