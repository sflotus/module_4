package org.arthur.ss4_data_binding.controller;

import org.arthur.ss4_data_binding.model.Email;
import org.arthur.ss4_data_binding.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class EmailController {
    @Autowired
    IEmailService emailService;
    @GetMapping("")
    public String showInfoPage(Model model){
        List<String> languageList = new ArrayList<>();
        List<Integer> pageSizeList = new ArrayList<>();
        languageList.add("Vietnamese");
        languageList.add("English");
        languageList.add("Japanese");
        languageList.add("Chinese");
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        model.addAttribute("languageList",languageList);
        model.addAttribute("pageSizeList",pageSizeList);
        model.addAttribute("email",emailService.getInfo());
        model.addAttribute("newEmail", new Email());
        return "email";
    }
    @PostMapping("")
    public String update(@ModelAttribute("newEmail") Email email, RedirectAttributes redirectAttributes){
        emailService.update(email);
        redirectAttributes.addFlashAttribute("msg","Update successful");
        return "redirect:/";
    }
}
