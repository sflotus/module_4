package org.arthur.ss1_change_money.model;

public class MoneyChanger {
    private  double numA;
    private  double exchangeRate;

    public MoneyChanger(double numA, double exchangeRate) {
        this.numA = numA;
        this.exchangeRate = exchangeRate;
    }

    public double getNumA() {
        return numA;
    }

    public void setNumA(double numA) {
        this.numA = numA;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}

