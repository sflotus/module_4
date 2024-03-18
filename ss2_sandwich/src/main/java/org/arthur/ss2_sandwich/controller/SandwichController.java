package org.arthur.ss2_sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SandwichController {
    @GetMapping("")
    public String returnList(){
        return "list";
    }
    @PostMapping("")
    public String getInfo(@RequestParam("condiments") String[] condiments, Model model){
        model.addAttribute("condiments",condiments);
        return  "list";
    }
}
