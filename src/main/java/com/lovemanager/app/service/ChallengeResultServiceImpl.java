package com.lovemanager.app.service;

import com.lovemanager.app.data.base.CharacterRepository;
import com.lovemanager.app.data.base.UserRepository;
import com.lovemanager.app.models.Girl;
import com.lovemanager.app.models.basic.FlirtResult;
import com.lovemanager.app.service.base.ChallengeResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeResultServiceImpl implements ChallengeResultService {

    private UserRepository userRepository;
    private CharacterRepository characterRepository;

    @Autowired
    public ChallengeResultServiceImpl(UserRepository userRepository, CharacterRepository characterRepository){
        this.userRepository = userRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public FlirtResult calculateResult(String flirtType) {

        Girl activeGirl = characterRepository.getActiveGirl();

        if(activeGirl.getType().equals("weirdo")){
            characterRepository.levelUp(userRepository.getActive().getCharacterId());
            return new FlirtResult("She cannot witstand your great charm and quickly falls into your arms", true);
        }

        if(activeGirl.getType().equals(flirtType)){
            characterRepository.levelUp(userRepository.getActive().getCharacterId());
            return new FlirtResult("She cannot witstand your great charm and quickly falls into your arms", true);
        }


        characterRepository.deleteActiveCharacter(userRepository.getActive().getCharacterId());
        return new FlirtResult("Failure", false);
    }
}
