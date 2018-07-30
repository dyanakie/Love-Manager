package com.lovemanager.app.service;

import com.lovemanager.app.models.Girl;
import com.lovemanager.app.service.base.NextChallengeService;

import java.util.Random;

public class NextChallengeServiceImpl implements NextChallengeService {

    public final Random RANDOM = new Random();

    @Override
    public Girl getNextGirl(int level) {

        String type = getRandomType();
        int girlLevel = getRandomLevel(level);
        String[] params = getUrlPresentationName();


        return new Girl(params[0], params[2], params[1], type, girlLevel);

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
    public int getRandomLevel(int level) {

        return RANDOM.nextInt(level-1)+1;
    }

    @Override
    public String[] getUrlPresentationName() {

        int dice = RANDOM.nextInt(5)+1;
        String[] girl = new String[3];

        switch (dice){

            case 1:
                girl[0] = "/pics/blabla.jpg";
                girl[1] = "Larra";
                girl[2] = "You find Larra sitting in a coffee shop in the middle of the day.She is so gorgeous you just cannot stop staring...";
                return girl;

            case 2:
                girl[0] = "/pics/blabla.jpg";
                girl[1] = "Larra";
                girl[2] = "You find Larra sitting in a coffee shop in the middle of the day.She is so gorgeous you just cannot stop staring...";
                return girl;

            case 3:
                girl[0] = "/pics/blabla.jpg";
                girl[1] = "Larra";
                girl[2] = "You find Larra sitting in a coffee shop in the middle of the day.She is so gorgeous you just cannot stop staring...";
                return girl;

            case 4:
                girl[0] = "/pics/blabla.jpg";
                girl[1] = "Larra";
                girl[2] = "You find Larra sitting in a coffee shop in the middle of the day.She is so gorgeous you just cannot stop staring...";
                return girl;

            case 5:
                girl[0] = "/pics/blabla.jpg";
                girl[1] = "Larra";
                girl[2] = "You find Larra sitting in a coffee shop in the middle of the day.She is so gorgeous you just cannot stop staring...";
                return girl;


        }

        return new String[3];
    }


}
