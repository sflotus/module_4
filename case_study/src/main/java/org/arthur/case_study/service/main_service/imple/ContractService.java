package org.arthur.case_study.service.main_service.imple;

import org.arthur.case_study.dto.ContractDTO;
import org.arthur.case_study.model.main_model.Contract;
import org.arthur.case_study.repository.main_repository.IContractRepository;
import org.arthur.case_study.service.main_service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public List<Contract> getList() {
        return contractRepository.findAll();
    }

    @Override
    public boolean add(Contract contract) {
         try{
             contractRepository.save(contract);
         } catch (Exception e){
            return  false;
         }
         return true;
    }

    @Override
    public boolean validDeposit(ContractDTO contractDTO) {
        return contractDTO.getDeposit() > 0;
    }

    @Override
    public Contract finById(Long id) {
        return contractRepository.findById(id).orElse(null);

    }
}
