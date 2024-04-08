package org.arthur.ss5_orm.controller;

import org.arthur.ss5_orm.model.MusicApp;
import org.arthur.ss5_orm.service.IMusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class MusicAppController {
    @Autowired
    IMusicAppService musicAppService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("list",musicAppService.getList());
        return "list";
    }
    @GetMapping("create")
    public String showAddForm(Model model){
        model.addAttribute("music",new MusicApp());
        return "create";
    }
    @PostMapping("create")
    public String Addnew(@ModelAttribute("music") MusicApp musicApp, RedirectAttributes redirectAttributes){
        String msg;
        if(musicAppService.addNew(musicApp)){
            msg="Add new song successful";
        } else msg="Add new song failed";
        redirectAttributes.addFlashAttribute("msg",msg);
        return "redirect:/";
    }
    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("music",new MusicApp());
        return "edit";
    }
}
