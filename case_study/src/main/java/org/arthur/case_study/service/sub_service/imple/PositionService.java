package org.arthur.case_study.service.sub_service.imple;

import org.arthur.case_study.model.sub_model.employee.Position;
import org.arthur.case_study.repository.sub_repository.IPositionRepository;
import org.arthur.case_study.service.sub_service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository positionRepository;
    @Override
    public List<Position> getList() {
        return positionRepository.findAll();
    }
}
