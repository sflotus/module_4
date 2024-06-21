package org.arthur.case_study.service.sub_service.imple;

import org.arthur.case_study.model.sub_model.customer.CustomerType;
import org.arthur.case_study.repository.sub_repository.ICustomerTypeRepository;
import org.arthur.case_study.service.sub_service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> getList() {
       return customerTypeRepository.findAll();
    }
}
