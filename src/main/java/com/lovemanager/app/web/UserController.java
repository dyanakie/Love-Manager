package com.lovemanager.app.web;

import com.lovemanager.app.models.User;
import com.lovemanager.app.service.base.CharacterService;
import com.lovemanager.app.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserService service;
    private CharacterService characterService;

    @Autowired
    public UserController(UserService service, CharacterService characterService) {
        this.service = service;
        this.characterService = characterService;
    }

    @GetMapping("/")
    public ModelAndView userRegisterView() {

        ModelAndView modelAndView = new ModelAndView("index");

        User user = new User();

        modelAndView.addObject("user", user);
        modelAndView.addObject("loginInfo", "If the user doesn't exist it will be created.");


        return modelAndView;

    }

    @PostMapping("/")
    public ModelAndView submitRegister(User user){

        ModelAndView modelAndView = new ModelAndView("index2");

        if(!service.checkPassword(user)){
            modelAndView.addObject("loginInfo", "Wrong username or password.");
            modelAndView.setViewName("index");
        }else {
            modelAndView.addObject("active", service.getActive());
        }
        return modelAndView;
    }

    @GetMapping("/index2")
    public ModelAndView redirectPage(){

        ModelAndView modelAndView = new ModelAndView("index2");



        modelAndView.addObject("active", service.getActive());

        return modelAndView;

    }




}
