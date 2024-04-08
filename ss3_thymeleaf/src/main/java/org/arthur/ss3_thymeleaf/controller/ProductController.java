package org.arthur.ss3_thymeleaf.controller;

import org.arthur.ss3_thymeleaf.model.Product;
import org.arthur.ss3_thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("productList",productService.getList());
        return "list";
    }
    @GetMapping("create")
    public String showCreateForm(Model model){
        model.addAttribute("newProduct",new Product());
        return "create";
    }
    @PostMapping("create")
    public String addNew(@ModelAttribute("newProduct") Product product, RedirectAttributes redirectAttributes){
        productService.addNew(product);
        redirectAttributes.addFlashAttribute("msg","Add new product success");
        return "redirect:/";
    }
    @GetMapping("edit/{id}")
    public String showEditFrom(@PathVariable int id, Model model){
        model.addAttribute(("product"),productService.getInfoById(id));
        return "edit";
    }
    @PostMapping("edit")
    public String editProduct(@ModelAttribute("newProduct") Product product,RedirectAttributes redirectAttributes){
        String msg ="Edit False";
        if(productService.update(product)){
            msg="Edit Success";
        }
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/";
    }
    @PostMapping("delete/{id}")
    public String deletdByID(@PathVariable int id,RedirectAttributes redirectAttributes){
        boolean isSuccess = productService.delete(id);
        String msg;
        if(isSuccess){
            msg = "Success";
        } else msg = "failed";
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/";
    }
}
