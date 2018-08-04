package com.lovemanager.app.service;

import com.lovemanager.app.data.base.CharacterRepository;
import com.lovemanager.app.data.base.UserRepository;
import com.lovemanager.app.models.Girl;
import com.lovemanager.app.service.base.GirlService;
import com.lovemanager.app.service.base.NextChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class NextChallengeServiceImpl implements NextChallengeService {

    public final Random RANDOM = new Random();
    private GirlService girlService;

    private CharacterRepository characterRepository;
    private UserRepository userRepository;

    @Autowired
    public NextChallengeServiceImpl(UserRepository userRepository, CharacterRepository characterRepository, GirlService girlService){
        this.userRepository = userRepository;
        this.characterRepository = characterRepository;
        this.girlService = girlService;

    }

    @Override
    public Girl getNextGirl() {                             // returns random girl with stats generated according to current level

        Girl newGirl = getGirl();

        newGirl.setLevel(generateGirlLevel());

        return newGirl;

    }

    @Override
    public List<Girl> getUnusedGirls(){

        HashSet<String> usedGirls = girlService.loadUsedGirls();

       return girlService.loadAllGirls().stream()
                .filter(x -> !usedGirls.contains(x.getName()))
                .collect(Collectors.toList());

    }

    @Override
    public Girl getGirl(){

        List<Girl> girls = getUnusedGirls();

        if(girls.size() == 1){
            return girls.get(0);
        }

        int number = RANDOM.nextInt(girls.size()-1);

        girlService.addUsedGirl(girls.get(number).getName());

        return girls.get(number);

    }



    @Override
    public int generateGirlLevel() {

        int level = characterRepository.getCharacterById(userRepository.getActive().getCharacterId()).getLevel();

        System.out.println("Character level: " + level);

        level = RANDOM.nextInt(level+1);

        System.out.println("Generated girl Level: " + level);

        if(level < 0){
            level = 0;
        }

        return 0;
    }


}
