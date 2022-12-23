package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showList(Model model){
        List<User> userList = iUserService.findAll();
        model.addAttribute("userList",userList);
        return "views/list";
    }
    @GetMapping("/create")
    public String create(Model model ){
        model.addAttribute("userDto",new UserDto());
        return "views/create";
    }
    @PostMapping("save")
    public String save(@Validated @ModelAttribute UserDto userDto , BindingResult bindingResult) {
     if (bindingResult.hasErrors()){
         return "views/create";
     }else {
         User user1 = new User();
         BeanUtils.copyProperties(userDto , user1);
         iUserService.save(user1);
         return "redirect:/user";
     }
    }

}
