package com.lovemanager.app.web;

import com.lovemanager.app.service.base.CharacterService;
import com.lovemanager.app.service.base.ItemService;
import com.lovemanager.app.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    private CharacterService characterService;
    private ItemService itemService;
    private UserService service;

    @Autowired
    public ItemController(CharacterService characterService, ItemService itemService, UserService service){
        this.characterService = characterService;
        this.itemService = itemService;
        this.service = service;
    }

    @RequestMapping("/changeItem/{item}")
    public String getById(@PathVariable("item") String item){

        String[] itemSplit = item.split(" ");

        switch (itemSplit[0]){

            case "accessorie":
                itemService.changeCurrentAccessorie(service.getActive().getCharacterId(), itemSplit[1]);
                break;

            case "vehicle":
                itemService.changeCurrentVehicle(service.getActive().getCharacterId(), itemSplit[1]);
                break;

            case "outfit":
                itemService.changeCurrentOutfit(service.getActive().getCharacterId(), itemSplit[1]);
                break;
            default: break;
        }

        return "redirect:/mainGameScreen";
    }

}
