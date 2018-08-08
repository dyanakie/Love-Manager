package com.lovemanager.app.service;

import com.lovemanager.app.data.base.CharacterRepository;
import com.lovemanager.app.data.base.UserRepository;
import com.lovemanager.app.models.Girl;
import com.lovemanager.app.models.basic.FlirtResult;
import com.lovemanager.app.models.basic.Item;
import com.lovemanager.app.service.base.ChallengeResultService;
import com.lovemanager.app.service.base.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeResultServiceImpl implements ChallengeResultService {

    private UserRepository userRepository;
    private CharacterRepository characterRepository;
    private ItemService itemService;

    @Autowired
    public ChallengeResultServiceImpl(UserRepository userRepository, CharacterRepository characterRepository, ItemService itemService){
        this.userRepository = userRepository;
        this.characterRepository = characterRepository;
        this.itemService = itemService;
    }

    @Override
    public FlirtResult calculateResult(String flirtType) {                                                     // check if flirt type matches girl type
                                                                                                           //if yes checks if girl level is equal or higher than character specific skill
        Girl activeGirl = characterRepository.getActiveGirl();

        if(activeGirl.getType().equals("weirdo")){
            levelUp(flirtType);
            return new FlirtResult("She cannot witstand your great charm and quickly falls into your arms", true);
        }

        System.out.println("Girl Level: " + activeGirl.getLevel());

        int characterId = userRepository.getActive().getCharacterId();

        int itemBonus = getItemBonusByType(flirtType, characterId);
        int characterStat = characterRepository.getCharacterById(characterId).getStatLevelByType(flirtType);

        int totalPoints = characterStat + itemBonus;

        if(activeGirl.getType().equals(flirtType)){

            if(activeGirl.getLevel() <= totalPoints) {

                levelUp(flirtType);

                return new FlirtResult("She cannot witstand your great charm and quickly falls into your arms!      Your " + flirtType + " level: " + totalPoints + "   Her " + flirtType + " level: " + activeGirl.getLevel(), true);
            }else{

                characterRepository.deleteActiveCharacter(userRepository.getActive().getCharacterId());
                return new FlirtResult("Your approach suits her type but your skill level isn't enough to impress her...  Her Level: " + activeGirl.getLevel() , false);

            }
        }


        characterRepository.deleteActiveCharacter(userRepository.getActive().getCharacterId());                                      // deletes character if fails
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

    private int getItemBonusByType(String type, int characterId){

            switch (type){

                case "intelligence":
                   Item a = itemService.getAllItems().stream()
                            .filter(x -> x.getName().equals(characterRepository.getCharacterById(characterId).getOutfit()))
                            .findFirst()
                            .orElse(null);
                   return a.getBonus();

                case "physique":
                    Item b = itemService.getAllItems().stream()
                            .filter(x -> x.getName().equals(characterRepository.getCharacterById(characterId).getAccessories()))
                            .findFirst()
                            .orElse(null);
                    return b.getBonus();

                case "status":
                    Item c = itemService.getAllItems().stream()
                            .filter(x -> x.getName().equals(characterRepository.getCharacterById(characterId).getVehicle()))
                            .findFirst()
                            .orElse(null);
                    return c.getBonus();

                default: return 0;


            }


    }



}
