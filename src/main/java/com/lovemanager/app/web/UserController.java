package com.lovemanager.app.web;

import com.lovemanager.app.models.User;
import com.lovemanager.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView userRegisterView() {

        ModelAndView modelAndView = new ModelAndView("index");

        User user = new User();

        modelAndView.addObject("user", user);

        return modelAndView;

    }

    @PostMapping("/")
    public ModelAndView submitRegister(User user){

        ModelAndView modelAndView = new ModelAndView("index2");

        service.checkOrCreateUser(user);

        return modelAndView;
    }


}
