package com.lovemanager.app.service;

import com.lovemanager.app.data.base.CharacterRepository;
import com.lovemanager.app.data.base.UserRepository;
import com.lovemanager.app.models.Girl;
import com.lovemanager.app.service.base.NextChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NextChallengeServiceImpl implements NextChallengeService {

    public final Random RANDOM = new Random();

    private CharacterRepository characterRepository;
    private UserRepository userRepository;

    @Autowired
    public NextChallengeServiceImpl(UserRepository userRepository, CharacterRepository characterRepository){
        this.userRepository = userRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public Girl getNextGirl() {                             // returns random girl with stats generated according to current level

      //  String type = getRandomType();
        String[] params = getUrlPresentationName();

        int level = generateGirlLevel();

        return new Girl(params[0], params[2], params[1], params[3], level);

    }

    @Override
    public String[] getUrlPresentationName() {

        int dice = RANDOM.nextInt(6)+1;
        String[] girl = new String[4];

        switch (dice){

            case 1:
                girl[0] = "/pics/girls/test.jpg";
                girl[1] = "Larra";
                girl[2] = "You find Larra sitting in a coffee shop in the middle of the day.She is so gorgeous you just cannot stop staring...";
                girl[3] = "status";
                return girl;

            case 2:
                girl[0] = "/pics/girls/Eve.jpg";
                girl[1] = "Eve";
                girl[2] = "You find Eve at a night club.She drops one of her drinks and you hurry to help her...";
                girl[3] = "physique";
                return girl;

            case 3:
                girl[0] = "/pics/girls/Manoela.jpg";
                girl[1] = "Manoela";
                girl[2] = "You find Manoela at a Java conference discussing current convention rules...";
                girl[3] = "intelligence";
                return girl;

            case 4:
                girl[0] = "/pics/girls/Penka.jpg";
                girl[1] = "Penka";
                girl[2] = "You find Penka in local chat channel when you are matched...";
                girl[3] = "physique";
                return girl;

            case 5:
                girl[0] = "/pics/girls/Helga.jpg";
                girl[1] = "Helga";
                girl[2] = "You find Helga in a night bar very drunk and almost crawling on the floor...";
                girl[3] = "status";
                return girl;

            case 6:
                girl[0] = "/pics/girls/Maria.jpg";
                girl[1] = "Maria";
                girl[2] = "You find Maria at class for scubadivers.Oh boy what you do for love...";
                girl[3] = "intelligence";
                return girl;


        }

        return new String[3];
    }

    @Override
    public int generateGirlLevel() {

        int level = characterRepository.getCharacterById(userRepository.getActive().getCharacterId()).getLevel();

        level = RANDOM.nextInt(level+1)+(level-2);

        if(level <0){
            level = 0;
        }

        return level;
    }


}
