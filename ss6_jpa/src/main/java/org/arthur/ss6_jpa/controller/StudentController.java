package org.arthur.ss6_jpa.controller;

import jakarta.validation.Valid;
import org.arthur.ss6_jpa.dto.StudentDTO;
import org.arthur.ss6_jpa.model.Student;
import org.arthur.ss6_jpa.model.StudentClass;
import org.arthur.ss6_jpa.service.IStudentClassService;
import org.arthur.ss6_jpa.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    IStudentService studentService;
    @Autowired
    IStudentClassService studentClassService;

    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(defaultValue = "",required = false) String valueSearch,
                           @RequestParam(defaultValue = "0",required = false) int page)  {
        // Page là trang hiện tại
        // Pagesize là số lượng record mỗi trang
        // sort là trường cần sắp xếp.
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page,5,sort);
        model.addAttribute("currentPage",page);
        model.addAttribute("valueSearch",valueSearch);
        model.addAttribute("list",studentService.findStudentByNameContainingAndActive(valueSearch,pageable));
        return "list";
    }

    @GetMapping("create")
    public String showAddForm(Model model) {
        model.addAttribute("classList",studentClassService.getList());
        model.addAttribute("studentDTO", new StudentDTO());
        model.addAttribute("class", new StudentClass());
        return "create";
    }

    @PostMapping("create")
    public String Addnew(@Valid @ModelAttribute("studentDTO") StudentDTO studentDTO, BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes) {
//        StudentDTO studentDTO1 = new StudentDTO();
//        studentDTO1.setEmailList();
//        studentDTO1.validate(studentDTO,bindingResult);
        if(studentService.isExitEmail(studentDTO)){
            FieldError error = new FieldError("studentDTO", "email", "Email đã tồn tại");
            bindingResult.addError(error);
        }
        if (bindingResult.hasErrors()){
            model.addAttribute("classList",studentClassService.getList());
            model.addAttribute("class",new StudentClass());
            return "create";
        }
        String msg;
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO,student);
        if (studentService.add(student)) {
            msg = "Add new student successful";
        } else msg = "Add new Student failed";
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/";
    }

    @GetMapping("edit")
    public String showEdit(@RequestParam(required = false) Long id, Model model) {
        model.addAttribute("classList",studentClassService.getList());
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(studentService.findById(id),studentDTO);
        model.addAttribute("student",studentDTO);
        model.addAttribute("class", new StudentClass());
        return "edit";
    }
    @PostMapping("edit")
    public String edit(@RequestParam(required = false) Long id,
                       @Valid @ModelAttribute("student") StudentDTO studentDTO,
                       BindingResult bindingResult, RedirectAttributes redirectAttributes,
                       Model model) {
        if(studentService.isExitEmail(studentDTO)){
            FieldError error = new FieldError("studentDTO", "email", "Email đã tồn tại");
            bindingResult.addError(error);
        }
        if (bindingResult.hasErrors()){
            model.addAttribute("classList",studentClassService.getList());
            model.addAttribute("class",new StudentClass());
            model.addAttribute("student",studentDTO);
            return "edit";
        }
        studentDTO.setId(id);
        String msg;
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO,student);
        if (studentService.add(student)) {
            msg = "Edit successful";
        } else msg = "Edit failed";
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/";
    }
    @PostMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
        Student student = studentService.findById(id);
        String msg;
        if (studentService.delete(student)) {
            msg = "Delete successful";
        } else msg = "Delete failed";
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/";
    }
//    @GetMapping("error")
//    public String returnErrorPage(){
//        return "error";
//    }
}
