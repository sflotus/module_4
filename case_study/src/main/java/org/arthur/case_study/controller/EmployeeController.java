package org.arthur.case_study.controller;

import jakarta.validation.Valid;
import org.arthur.case_study.dto.EmployeeDTO;
import org.arthur.case_study.model.main_model.Employee;
import org.arthur.case_study.service.main_service.IEmployeeService;
import org.arthur.case_study.service.sub_service.IDivisionService;
import org.arthur.case_study.service.sub_service.IEducationDegreeService;
import org.arthur.case_study.service.sub_service.IPositionService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IEducationDegreeService educationDegreeService;
    @GetMapping("/list")
    public String showListEmployee(Model model,
                                   @RequestParam(defaultValue = "",required = false) String valueSearch,
                                   @RequestParam(defaultValue = "0",required = false) int page){
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(page,5,sort);
        model.addAttribute("currentPage",page);
        model.addAttribute("valueSearch",valueSearch);
        model.addAttribute("list",employeeService.findAll(valueSearch,pageable));
        return "employee/list";
    }
    @GetMapping("create")
    public String showCreateForm(Model model){
        model.addAttribute("employeeDTO",new EmployeeDTO());
        model.addAttribute("listPosition",positionService.getList());
        model.addAttribute("listEducationDegree",educationDegreeService.getList());
        model.addAttribute("listDivision",divisionService.getList());
        return "/employee/create";
    }
    @PostMapping("create")
    public String addNewCustomer(Model model,
                                 @Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new EmployeeDTO().validate(employeeDTO,bindingResult);
        if(employeeService.checkExistEmail(employeeDTO)){
            FieldError error = new FieldError("employeeDTO", "email", "Email has been exist");
            bindingResult.addError(error);
        }
        if(employeeService.checkExistIdCard(employeeDTO)){
            FieldError error = new FieldError("employeeDTO", "idCard", "ID card has been exist");
            bindingResult.addError(error);
        }
        if(employeeService.checkExistPhoneNumber(employeeDTO)){
            FieldError error = new FieldError("employeeDTO", "phoneNumber", "Phone Number has been exist");
            bindingResult.addError(error);
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("listPosition",positionService.getList());
            model.addAttribute("listEducationDegree",educationDegreeService.getList());
            model.addAttribute("listDivision",divisionService.getList());
            return "/employee/create";
        }
        Employee employee =  new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        String msg = employeeService.add(employee) ? "Add new employee successful" : "Failed";
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/employee/list";
    }
}
