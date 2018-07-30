package com.lovemanager.app.web;


import com.lovemanager.app.models.Girl;
import com.lovemanager.app.service.base.CharacterService;
import com.lovemanager.app.service.base.NextChallengeService;
import com.lovemanager.app.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class NextChallengeController {

    private NextChallengeService nextChallengeService;
    private UserService service;
    private CharacterService characterService;

    @Autowired
    public NextChallengeController(NextChallengeService nextChallengeService, UserService service, CharacterService characterService){
        this.nextChallengeService = nextChallengeService;
        this.characterService = characterService;
        this.service = service;
    }

    @GetMapping("/nextChallenge")
    public ModelAndView nextChallenge(ModelMap model){

        //logic

        ModelAndView modelAndView = new ModelAndView("nextChallenge");

        Girl newGirl = nextChallengeService.getNextGirl(characterService.getCharacterById(service.getActive().getCharacterId()).getLevel());

        System.out.println("level: " + newGirl.getLevel());
        System.out.println("pic: " + newGirl.getPicUrl());
        System.out.println("pres: " + newGirl.getPresentation());
        System.out.println("type: " + newGirl.getType());

        modelAndView.addObject("girl", newGirl);


        return modelAndView;
    }
}
