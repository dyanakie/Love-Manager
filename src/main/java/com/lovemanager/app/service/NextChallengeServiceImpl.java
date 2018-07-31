package com.lovemanager.app.service;

import com.lovemanager.app.data.base.UserRepository;
import com.lovemanager.app.models.Girl;
import com.lovemanager.app.service.base.NextChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NextChallengeServiceImpl implements NextChallengeService {

    public final Random RANDOM = new Random();
    private UserRepository userRepository;

    @Autowired
    public NextChallengeServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Girl getNextGirl() {                             // returns girl generated according to current level

        String type = getRandomType();
        String[] params = getUrlPresentationName();


        return new Girl(params[0], params[2], params[1], type);

    }

    @Override
    public String getRandomType() {

        int dice = RANDOM.nextInt(4)+1;

        switch (dice){

            case 1: return "intelligence";

            case 2: return "status";

            case 3: return "physique";

            case 4: return "weirdo";

        }

        return null;
    }

    @Override
    public String[] getUrlPresentationName() {

        int dice = RANDOM.nextInt(4)+1;
        String[] girl = new String[3];

        switch (dice){

            case 1:
                girl[0] = "/pics/girls/test.jpg";
                girl[1] = "Larra";
                girl[2] = "You find Larra sitting in a coffee shop in the middle of the day.She is so gorgeous you just cannot stop staring...";
                return girl;

            case 2:
                girl[0] = "/pics/girls/Eve.jpg";
                girl[1] = "Eve";
                girl[2] = "You find Eve at a night club.She drops one of her drinks and you hurry to help her...";
                return girl;

            case 3:
                girl[0] = "/pics/girls/Manoela.jpg";
                girl[1] = "Manoela";
                girl[2] = "You find Manoela at a Java conference discussing current convention rules...";
                return girl;

            case 4:
                girl[0] = "/pics/girls/Penka.jpg";
                girl[1] = "Penka";
                girl[2] = "You find Penka in local chat channel when you are matched...";
                return girl;

            case 5:
                girl[0] = "/pics/girls/test.jpg";
                girl[1] = "Larra";
                girl[2] = "You find Larra sitting in a coffee shop in the middle of the day.She is so gorgeous you just cannot stop staring...";
                return girl;


        }

        return new String[3];
    }


}
