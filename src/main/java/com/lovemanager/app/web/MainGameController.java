package com.lovemanager.app.web;

import com.lovemanager.app.models.basic.Item;
import com.lovemanager.app.models.basic.ActiveItem;
import com.lovemanager.app.service.base.CharacterService;
import com.lovemanager.app.service.base.ItemService;
import com.lovemanager.app.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainGameController {

    private UserService service;
    private CharacterService characterService;
    private ItemService itemService;

    @Autowired
    public MainGameController(UserService service, CharacterService characterService, ItemService itemService){

        this.service = service;
        this.characterService = characterService;
        this.itemService = itemService;

    }

    @GetMapping("/mainGameScreen")
    public ModelAndView mainGameView(){

        ModelAndView modelAndView = new ModelAndView("mainGameScreen");

        characterService.createCharacter();

        modelAndView.addObject(service.getActive());

        modelAndView.addObject("character", characterService.getCharacterById(service.getActive().getCharacterId()));

        modelAndView.addObject("activeItem", new ActiveItem("pics/items/vehicles/bicycle.png", "pics/items/accessories/glasses.png", "pics/items/outfits/shirt.png"));

        int currentLevel =  characterService.getCharacterById(service.getActive().getCharacterId()).getLevel();

        List<Item> accessories = itemService.getAllAccessories(currentLevel);
        List<Item> vehicles = itemService.getAllVehicles(currentLevel);
        List<Item> outfit = itemService.getAllOutfits(currentLevel);

        modelAndView.addObject("accessories", accessories);
        modelAndView.addObject("vehicles", vehicles);
        modelAndView.addObject("outfit", outfit);

        return modelAndView;

    }


}
