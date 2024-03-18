package org.arthur.ss2_calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class controller {
    @GetMapping("")
    public String returnCalculator() {
        return "calculator";
    }

    @PostMapping("{operator}")
    public String calculator(@PathVariable String operator, @RequestParam double numA, @RequestParam double numB, Model model) {
        String result = "";
        switch (operator) {
            case "add":
                result = String.valueOf(numA + numB);
                break;
            case "sub":
                result = String.valueOf(numA - numB);
                break;
            case "mul":
                result = String.valueOf(numA * numB);
                break;
            case "div":
                if (numB == 0) {
                    result = "can not division to 0";
                } else result = String.valueOf(numA / numB);
                break;

        }
        model.addAttribute("result",result);
        return "calculator";
    }
}
