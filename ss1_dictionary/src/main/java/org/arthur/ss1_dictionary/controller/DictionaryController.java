package org.arthur.ss1_dictionary.controller;

import org.arthur.ss1_dictionary.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class DictionaryController {
    @Autowired
    IService service;
    @GetMapping("")
    public String HomePage(){
        return "result";
    }
    @PostMapping("")
    public String search(Model model, @RequestParam String ENGword){
        String result = service.search(ENGword);
        if(result == null){
            result = " khong tim thay du lieu";
        }
        model.addAttribute("ENGword",ENGword);
        model.addAttribute("VNWord",result);
        return "result";
    }
}
