package com.codegym.controller;

import com.codegym.model.Mailbox;
import com.codegym.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class ElectronicMailboxController {
    @Autowired
    private IMailboxService iMailboxService;

    @RequestMapping("")
    public String showList(ModelMap modelMap){
        List<Mailbox> mailboxList = iMailboxService.finAll();
        modelMap.addAttribute("mailboxList",mailboxList);
        return "list";
    }

    @GetMapping ("/edit/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model){
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");

        model.addAttribute("languageList", languageList);

        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);

        model.addAttribute("pageSizeList", pageSizeList);

        Mailbox mailbox = iMailboxService.findIndexById(id);
        if (mailbox == null) {
            throw new IllegalArgumentException("Not found mailbox");
        }
        model.addAttribute("mailbox",mailbox);
        return "edit";

    }
    @PostMapping("/edit")
    public String update(@ModelAttribute("mailbox") Mailbox mailbox , Model model , RedirectAttributes redirectAttributes){
    iMailboxService.save(mailbox);
    redirectAttributes.addFlashAttribute("message","massege: đã chỉnh sửa thành công");
        List<Mailbox> mailboxList = iMailboxService.finAll();
        model.addAttribute("mailboxList",mailboxList);
    return "list";
    }
}
