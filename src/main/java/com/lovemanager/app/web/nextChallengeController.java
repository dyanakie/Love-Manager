package com.lovemanager.app.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class nextChallengeController {

    @GetMapping("/nextChallenge")
    public ModelAndView nextChallenge(ModelMap model){

        //logic


        return new ModelAndView("redirect:/mainGameScreen", model);
    }

}
