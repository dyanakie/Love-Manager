package com.lovemanager.app.web;

import com.lovemanager.app.service.base.CharacterService;
import com.lovemanager.app.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainGameController {

    private UserService service;
    private CharacterService characterService;

    @Autowired
    public MainGameController(UserService service, CharacterService characterService){

        this.service = service;
        this.characterService = characterService;
    }

    @GetMapping("/mainGameScreen")
    public ModelAndView mainGameView(){

        ModelAndView modelAndView = new ModelAndView("mainGameScreen");

        modelAndView.addObject(service.getActive());

        modelAndView.addObject("character", characterService.getCharacterById(service.getActive().getCharacterId()));


        return modelAndView;

    }


}
