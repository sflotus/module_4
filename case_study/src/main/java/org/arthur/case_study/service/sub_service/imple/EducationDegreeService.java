package org.arthur.case_study.service.sub_service.imple;

import org.arthur.case_study.model.sub_model.employee.EducationDegree;
import org.arthur.case_study.repository.sub_repository.IEducationDegreeRepository;
import org.arthur.case_study.service.sub_service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> getList() {
        return educationDegreeRepository.findAll();
    }
}
