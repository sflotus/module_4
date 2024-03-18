package org.arthur.ss1_change_money.service.imple;

import org.arthur.ss1_change_money.model.MoneyChanger;
import org.arthur.ss1_change_money.repo.IMoneyChangerRepo;
import org.arthur.ss1_change_money.service.IMoneyChangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyChangerService implements IMoneyChangerService {
    @Autowired
    IMoneyChangerRepo moneyChangerRepo;
    @Override
    public double calculatorResult(MoneyChanger moneyChanger) {
        return moneyChangerRepo.calculatorResult(moneyChanger);
    }
}
