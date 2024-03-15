package org.arthur.ss1.controller;

import org.arthur.ss1.model.Student;
import org.arthur.ss1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    IStudentService studentService;
    @GetMapping("")
    public String  showList(Model model){
        model.addAttribute("list",studentService.getList());
        return "list";
    }
    @GetMapping("/create")
    public String showAddForm(){
        return "create";
    }
    @PostMapping("/create")
    public String add(@RequestParam int id, @RequestParam String name, @RequestParam String desc){
        studentService.add(new Student(id, name,desc));
        return "redirect:/";
    }
}
