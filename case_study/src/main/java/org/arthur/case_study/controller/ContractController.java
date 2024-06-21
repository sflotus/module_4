package org.arthur.case_study.controller;

import jakarta.validation.Valid;
import org.arthur.case_study.dto.ContractDTO;
import org.arthur.case_study.model.main_model.Contract;
import org.arthur.case_study.service.main_service.IContractService;
import org.arthur.case_study.service.main_service.ICustomerService;
import org.arthur.case_study.service.main_service.IEmployeeService;
import org.arthur.case_study.service.main_service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping({"/contract","/"})
public class ContractController {
    @Autowired
    IContractService contractService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IFacilityService facilityService;
    @GetMapping({"/list","/"})
    public String showListContract(Model model,
                                   @RequestParam(defaultValue = "",required = false) String valueSearch,
                                   @RequestParam(defaultValue = "0",required = false) int page){
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(page,10,sort);
        model.addAttribute("currentPage",page);
        model.addAttribute("valueSearch",valueSearch);
        model.addAttribute("list",contractService.findAll(pageable));
        return "contract/list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("contractDTO",new ContractDTO());
        model.addAttribute("listEmployee",employeeService.getList());
        model.addAttribute("listCustomer",customerService.getList());
        model.addAttribute("listFacility",facilityService.getList());
        return "contract/create";
    }
    @PostMapping("/create")
    public String addNewContract(@Valid @ModelAttribute("contractDTO") ContractDTO contractDTO,
                                 BindingResult bindingResult,
                                 Model model,
                                 RedirectAttributes redirectAttributes
                                 ){
        new ContractDTO().validate(contractDTO,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("listEmployee",employeeService.getList());
            model.addAttribute("listCustomer",customerService.getList());
            model.addAttribute("listFacility",facilityService.getList());
            return "contract/create";
        }
        Contract contract =  new Contract();
        BeanUtils.copyProperties(contractDTO,contract);
        String msg = contractService.add(contract) ? "Add new contract successful" : "Failed";
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/list";
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") Long id,Model model){
        model.addAttribute("contractDTO",contractService.finById(id));
        model.addAttribute("listEmployee",employeeService.getList());
        model.addAttribute("listCustomer",customerService.getList());
        model.addAttribute("listFacility",facilityService.getList());
        return "contract/edit";
    }
}
