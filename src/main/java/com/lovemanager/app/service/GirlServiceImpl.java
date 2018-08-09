package com.lovemanager.app.service;

import com.lovemanager.app.data.base.CharacterRepository;
import com.lovemanager.app.data.base.GirlsRepository;
import com.lovemanager.app.data.base.UserRepository;
import com.lovemanager.app.models.Girl;
import com.lovemanager.app.service.base.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Service
public class GirlServiceImpl implements GirlService {

    private UserRepository userRepository;
    private CharacterRepository characterRepository;
    private GirlsRepository girlsRepository;

    @Autowired
    public GirlServiceImpl(UserRepository userRepository, CharacterRepository characterRepository, GirlsRepository girlsRepository){
        this.userRepository = userRepository;
        this.characterRepository = characterRepository;
        this.girlsRepository = girlsRepository;
    }

    @Override
    public void saveGirl(Girl girl) {

        characterRepository.saveGirl(girl);

    }

    @Override
    public ArrayList<Girl> loadAllGirls(){


        List<Girl> pool = new LinkedList<>();

        pool.add(new Girl("/pics/girls/test.jpg", "You find Larra sitting in a coffee shop in the middle of the day.She is dressed gorgeously and seems to know she is attractive...", "Larra", "status", 0));
        pool.add(new Girl("/pics/girls/Eve.jpg", "You find Eve at a night club.She drops one of her drinks and you hurry to help her...", "Eve", "physique", 0));
        pool.add(new Girl("/pics/girls/Manoela.jpg","You find Manoela at a Java conference discussing current convention rules...", "Manoela", "intelligence", 0));
        pool.add(new Girl("/pics/girls/Penka.jpg","You find Penka in local chat channel when you are matched...", "Penka","physique", 0 ));
        pool.add(new Girl("/pics/girls/Helga.jpg", "You find Helga in a night bar very drunk.She asks what do you work and if you can buy her a drink...", "Helga","status", 0 ));
        pool.add(new Girl("/pics/girls/Maria.jpg", "You find Maria at class for scubadivers.She seems to know her thing very well...", "Maria", "intelligence", 0 ));
        pool.add(new Girl("/pics/girls/Kornelia.jpg", "You find Cornelia at a dating website for sex arrangement...", "Cornelia", "physique", 0));
        pool.add(new Girl("/pics/girls/Elizabeth.jpg", "You find Elizabeth at a business conference.She is a manager of a successful Real Estate company...", "Elizabeth", "status", 0));
        pool.add(new Girl("/pics/girls/Dezdemona.jpg", "You find Dezdemona reading a book in the park.You save her from a barking dog and start talking...", "Dezdemona", "intelligence", 0));

        return new ArrayList<Girl>(pool);
    }

    @Override
    public HashSet<String> loadUsedGirls() {                                                                       // loads all girls that are used by this character to a hashset for check later

        String[] used = girlsRepository.getUsedGirls(userRepository.getActive().getCharacterId()).split(" ");
        HashSet<String> hash = new HashSet<>();

        for (String a:
             used) {
            hash.add(a);
        }

        return hash;
    }

    @Override
    public void addUsedGirl(String name){                                                             // adds a girl that was used to the table data
        girlsRepository.addUsedGirl(userRepository.getActive().getCharacterId(), name);
    }


}
