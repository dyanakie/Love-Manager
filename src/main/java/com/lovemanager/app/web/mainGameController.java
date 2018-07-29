package com.lovemanager.app.web;

import com.lovemanager.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mainGameController {

    private UserService service;

    @Autowired
    public mainGameController(UserService service){
        this.service = service;
    }

    @GetMapping("/mainGameScreen")
    public ModelAndView mainGameView(){

        ModelAndView modelAndView = new ModelAndView("mainGameScreen");

        modelAndView.addObject(service.getActive());

        return modelAndView;

    }


}
