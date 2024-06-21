package org.arthur.case_study.controller;

import jakarta.validation.Valid;
import org.arthur.case_study.dto.CustomerDTO;
import org.arthur.case_study.model.main_model.Customer;
import org.arthur.case_study.service.main_service.ICustomerService;
import org.arthur.case_study.service.sub_service.ICustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;
    @GetMapping("/list")
    public String showListCustomer(Model model,
                                   @RequestParam(defaultValue = "",required = false) String valueSearch,
                                   @RequestParam(defaultValue = "0",required = false) int page){
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(page,5,sort);
        model.addAttribute("currentPage",page);
        model.addAttribute("valueSearch",valueSearch);
        model.addAttribute("list",customerService.findAll(valueSearch,pageable));
        return "customer/list";
    }
    @GetMapping("create")
    public String showCreateForm(Model model){
        model.addAttribute("customerDTO",new CustomerDTO());
        model.addAttribute("listCustomerType",customerTypeService.getList());
        return "/customer/create";
    }
    @PostMapping("create")
    public String addNewCustomer(Model model,
                                 @Valid @ModelAttribute("customerDTO") CustomerDTO customerDTO,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new CustomerDTO().validate(customerDTO,bindingResult);
        if(customerService.checkExsitEmail(customerDTO)){
            FieldError error = new FieldError("customerDTO", "email", "Email has been exist");
            bindingResult.addError(error);
        }
        if(customerService.checkExisIdCard(customerDTO)){
            FieldError error = new FieldError("customerDTO", "idCard", "ID card has been exist");
            bindingResult.addError(error);
        }
        if (customerService.checkExistPhoneNumber(customerDTO)){
            FieldError error = new FieldError("customerDTO", "phoneNumber", "ID card has been exist");
            bindingResult.addError(error);
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("listCustomerType",customerTypeService.getList());
            return "/customer/create";
        }
        Customer customer =  new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        String msg = customerService.add(customer) ? "Add new customer successful" : "Failed";
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/customer/list";
    }
}
