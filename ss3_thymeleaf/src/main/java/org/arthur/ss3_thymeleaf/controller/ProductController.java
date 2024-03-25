package org.arthur.ss3_thymeleaf.controller;

import org.arthur.ss3_thymeleaf.model.Product;
import org.arthur.ss3_thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        redirectAttributes.addFlashAttribute("msg","Them moi thanh cong");
        return "redirect:/";
    }
}
