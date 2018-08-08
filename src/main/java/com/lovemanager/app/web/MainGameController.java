package com.lovemanager.app.web;

import com.lovemanager.app.models.Character;
import com.lovemanager.app.models.basic.Item;
import com.lovemanager.app.models.basic.ActiveItem;
import com.lovemanager.app.service.ChallengeResultServiceImpl;
import com.lovemanager.app.service.base.ChallengeResultService;
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

    private String accessoryUrl;
    private String outfitUrl;
    private String vehicleUrl;

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

        Character character =  loadCurrentCharacter();

        modelAndView.addObject("character", character);

        modelAndView.addObject("activeItem", new ActiveItem(vehicleUrl, outfitUrl, accessoryUrl));

        int currentLevel =  characterService.getCharacterById(service.getActive().getCharacterId()).getLevel();

        List<Item> accessories = itemService.getAllAccessories(currentLevel);
        List<Item> vehicles = itemService.getAllVehicles(currentLevel);
        List<Item> outfit = itemService.getAllOutfits(currentLevel);

        modelAndView.addObject("accessories", accessories);
        modelAndView.addObject("vehicles", vehicles);
        modelAndView.addObject("outfit", outfit);

        return modelAndView;

    }

    private Character loadCurrentCharacter(){

        Character character = characterService.getCharacterById(service.getActive().getCharacterId());

        String accessorie, vehicle, outfit;

        if(character.getLevel() ==1){
            accessorie = "glasses";
            vehicle = "bicycle";
            outfit = "sweat-suit";
            itemService.changeCurrentAccessorie(character.getId(), "glasses");
            itemService.changeCurrentOutfit(character.getId(), "sweat-suit");
            itemService.changeCurrentVehicle(character.getId(), "bicycle");
        }else {
            accessorie = itemService.getCurrentAccessorie(character.getId());
            vehicle = itemService.getCurrentVehicle(character.getId());
            outfit = itemService.getCurrentOutfit(character.getId());
        }

            for (Item a :
                    itemService.getAllItems()) {
                if (accessorie.equals(a.getName())) {
                    character.setPhysique(character.getPhysique() + a.getBonus());
                    accessoryUrl = a.getPicUrl();
                }

                if (outfit.equals(a.getName())) {
                    character.setIntelligence(character.getIntelligence() + a.getBonus());
                    outfitUrl = a.getPicUrl();
                }

                if (vehicle.equals(a.getName())) {
                    character.setStatus(character.getStatus() + a.getBonus());
                    vehicleUrl = a.getPicUrl();
                }
            }


        return character;

    }


}
