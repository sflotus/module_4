package org.arthur.case_study.service.main_service;

import org.arthur.case_study.dto.ContractDTO;
import org.arthur.case_study.model.main_model.Contract;
import org.arthur.case_study.model.main_model.Customer;
import org.arthur.case_study.model.main_model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);
    List<Contract> getList();
    boolean add(Contract contract);
    boolean validDeposit(ContractDTO contractDTO);
    Contract finById(Long id);

}
