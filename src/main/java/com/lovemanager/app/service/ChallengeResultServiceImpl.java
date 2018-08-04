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
            levelUp(flirtType);
            return new FlirtResult("She cannot witstand your great charm and quickly falls into your arms", true);
        }

        System.out.println("Girl Level: " + activeGirl.getLevel());

        if(activeGirl.getType().equals(flirtType)){

            if(activeGirl.getLevel() <= characterRepository.getCharacterById(userRepository.getActive().getCharacterId()).getStatLevelByType(flirtType)) {

                levelUp(flirtType);

                return new FlirtResult("She cannot witstand your great charm and quickly falls into your arms", true);
            }else{

                characterRepository.deleteActiveCharacter(userRepository.getActive().getCharacterId());
                return new FlirtResult("Your approach suits her type but your skill level isn't enough to impress her...  Her Level: " + activeGirl.getLevel() , false);

            }
        }


        characterRepository.deleteActiveCharacter(userRepository.getActive().getCharacterId());
        return new FlirtResult("Your approach doesn't fit her type and she stops answering your calls...", false);
    }

    @Override
    public void levelUp(String type) {

        int characterId = userRepository.getActive().getCharacterId();

        characterRepository.levelUp(characterId);

        switch (type){

            case "intelligence":
                characterRepository.changeIntelligence(characterId, 1);
                break;
            case "physique":
                characterRepository.changePhysique(characterId, 1);
                break;
            case "status":
                characterRepository.changeStatus(characterId, 1);
                break;
        }

    }


}
