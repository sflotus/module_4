package org.arthur.ss6_jpa.controller;

import org.arthur.ss6_jpa.model.StudentClass;
import org.arthur.ss6_jpa.service.IStudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    IStudentClassService studentClassService;
    @PostMapping("/create")
    public String addNewClass(@ModelAttribute("class")StudentClass studentClass,
                              @RequestParam(required = false) Long id,
                              RedirectAttributes redirectAttributes){
        String msg;
        if (studentClassService.addNew(studentClass)) {
            msg = "Add new class successful";
        } else msg = "failed";
        redirectAttributes.addFlashAttribute("msg", msg);
        if(id == null){
            return "redirect:/create";
        } else {
            return "redirect:/edit?id="+id;
        }
    }
}
