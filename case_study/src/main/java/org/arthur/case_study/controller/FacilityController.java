package org.arthur.case_study.controller;

import jakarta.validation.Valid;
import org.arthur.case_study.dto.EmployeeDTO;
import org.arthur.case_study.dto.FacilityDTO;
import org.arthur.case_study.model.main_model.Employee;
import org.arthur.case_study.model.main_model.Facility;
import org.arthur.case_study.repository.sub_repository.IFacilityTypeRepository;
import org.arthur.case_study.service.main_service.IFacilityService;
import org.arthur.case_study.service.sub_service.IFacilityTypeService;
import org.arthur.case_study.service.sub_service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityService facilityService;
    @Autowired
    IFacilityTypeService facilityTypeService;
    @Autowired
    IRentTypeService rentTypeService;
    @GetMapping("/list")
    public String showListFacility(Model model,
                                   @RequestParam(defaultValue = "",required = false) String valueSearch,
                                   @RequestParam(defaultValue = "0",required = false) int page){
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(page,5,sort);
        model.addAttribute("currentPage",page);
        model.addAttribute("valueSearch",valueSearch);
        model.addAttribute("list",facilityService.findAll(valueSearch,pageable));
        return "facility/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("facilityDTO", new FacilityDTO());
        model.addAttribute("listRentType", rentTypeService.getList());
        model.addAttribute("listFacilityType", facilityTypeService.getList());
        return "facility/create";
    }
    @PostMapping("/create")
    public String addNewFacility(Model model,
                                 @Valid @ModelAttribute("facilityDTO") FacilityDTO facilityDTO,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new FacilityDTO().validate(facilityDTO,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("listRentType",rentTypeService.getList());
            model.addAttribute("listFacilityType",facilityTypeService.getList());
            return "/facility/create";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDTO,facility);
        facility.setArea(Integer.parseInt(facilityDTO.getArea()));
        facility.setMaxPeople(Integer.parseInt(facilityDTO.getMaxPeople()));
        facility.setNumberOfFloors(Integer.parseInt(facilityDTO.getNumberOfFloors()));
        String msg = facilityService.add(facility) ? "Add new facility successful" : "Failed";
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/facility/list";
    }
}
