package org.arthur.ss1_change_money.repo.imple;

import org.arthur.ss1_change_money.model.MoneyChanger;
import org.arthur.ss1_change_money.repo.IMoneyChangerRepo;
import org.springframework.stereotype.Repository;

@Repository
public class MoneyChangerRepo implements IMoneyChangerRepo {
    @Override
    public double calculatorResult(MoneyChanger moneyChanger) {
        return moneyChanger.getNumA()* moneyChanger.getExchangeRate();
    }
}
