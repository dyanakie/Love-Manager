package com.lovemanager.app.web;

import com.lovemanager.app.service.base.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    private CharacterService characterService;

    @Autowired
    public ItemController(CharacterService characterService){
        this.characterService = characterService;
    }

    @RequestMapping("/changeItem/{item}")
    public String getById(@PathVariable("item") String item){



        return "index";
    }

}
