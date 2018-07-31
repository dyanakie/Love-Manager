package com.lovemanager.app.web;


import com.lovemanager.app.models.Girl;
import com.lovemanager.app.models.basic.FlirtResult;
import com.lovemanager.app.service.base.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class NextChallengeController {

    private NextChallengeService nextChallengeService;
    private UserService service;
    private CharacterService characterService;
    private GirlService girlService;
    private ChallengeResultService challengeResultService;

    @Autowired
    public NextChallengeController(NextChallengeService nextChallengeService, UserService service, CharacterService characterService, GirlService girlService, ChallengeResultService challengeResultService){
        this.nextChallengeService = nextChallengeService;
        this.characterService = characterService;
        this.service = service;
        this.girlService = girlService;
        this.challengeResultService = challengeResultService;
    }

    @GetMapping("/nextChallenge")
    public ModelAndView nextChallenge(ModelMap model){

        //logic

        ModelAndView modelAndView = new ModelAndView("nextChallenge");

        if(characterService.getCharacterById(service.getActive().getCharacterId()).getLevel() == 7){        // shows end game screen for successful game

            characterService.deleteCurrentCharacter(service.getActive().getCharacterId());
            return new ModelAndView("finish");
        }

        modelAndView.addObject(service.getActive());

        Girl newGirl = nextChallengeService.getNextGirl();

        System.out.println("pic: " + newGirl.getPicUrl());
        System.out.println("pres: " + newGirl.getPresentation());
        System.out.println("type: " + newGirl.getType());

        modelAndView.addObject("girl", newGirl);

        girlService.saveGirl(newGirl);

        return modelAndView;
    }

    @GetMapping("/intelligenceFlirt")
    public ModelAndView intelligenceFlirt(ModelAndView modelAndView){

        modelAndView.setViewName("flirtResult");

        modelAndView.addObject(service.getActive());

        modelAndView.addObject("flirtResult", challengeResultService.calculateResult("intelligence"));            // testing

        return modelAndView;

    }

    @GetMapping("/physicalFlirt")
    public ModelAndView physicalFlirt(ModelAndView modelAndView){

        //logic

        modelAndView.setViewName("flirtResult");

        modelAndView.addObject(service.getActive());

        modelAndView.addObject("flirtResult", challengeResultService.calculateResult("physique"));            // testing

        return modelAndView;

    }

    @GetMapping("/socialStatusFlirt")
    public ModelAndView socialStatusFlirt(ModelAndView modelAndView){

        modelAndView.setViewName("flirtResult");

        modelAndView.addObject(service.getActive());

        modelAndView.addObject("flirtResult", challengeResultService.calculateResult("status"));            // testing

        return modelAndView;

    }
}
