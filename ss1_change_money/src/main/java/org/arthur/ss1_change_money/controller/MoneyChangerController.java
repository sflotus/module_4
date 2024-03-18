package org.arthur.ss1_change_money.controller;

import org.arthur.ss1_change_money.model.MoneyChanger;
import org.arthur.ss1_change_money.service.IMoneyChangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MoneyChangerController {
    @Autowired
    IMoneyChangerService moneyChangerService;
    @GetMapping("")
    public String showPage(){
        return "result";
    }
    @PostMapping("")
    public String getResult(Model model, @RequestParam double numA,@RequestParam double exchangeRate){
        MoneyChanger moneyChanger = new MoneyChanger(numA, exchangeRate);
        model.addAttribute("result",moneyChangerService.calculatorResult(moneyChanger));
        model.addAttribute("numA",numA);
        model.addAttribute("exchangeRate",exchangeRate);
        return "result";
    };
}
