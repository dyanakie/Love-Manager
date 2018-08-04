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

        ArrayList<Girl> pool = new ArrayList<>();

        pool.add(new Girl("/pics/girls/test.jpg", "You find Larra sitting in a coffee shop in the middle of the day.She is so gorgeous you just cannot stop staring...", "Larra", "status", 0));
        pool.add(new Girl("/pics/girls/Eve.jpg", "You find Eve at a night club.She drops one of her drinks and you hurry to help her...", "Eve", "physique", 0));
        pool.add(new Girl("/pics/girls/Manoela.jpg","You find Manoela at a Java conference discussing current convention rules...", "Manoela", "intelligence", 0));
        pool.add(new Girl("/pics/girls/Penka.jpg","You find Penka in local chat channel when you are matched...", "Penka","physique", 0 ));
        pool.add(new Girl("/pics/girls/Helga.jpg", "You find Helga in a night bar very drunk and almost crawling on the floor...", "Helga","status", 0 ));
        pool.add(new Girl("/pics/girls/Maria.jpg", "You find Maria at class for scubadivers.Oh boy what you do for love...", "Maria", "intelligence", 0 ));

        return pool;
    }

    @Override
    public HashSet<String> loadUsedGirls() {

        String[] used = girlsRepository.getUsedGirls(userRepository.getActive().getCharacterId()).split(" ");
        HashSet<String> hash = new HashSet<>();

        for (String a:
             used) {
            hash.add(a);
        }

        return hash;
    }

    @Override
    public void addUsedGirl(String name){
        girlsRepository.addUsedGirl(userRepository.getActive().getCharacterId(), name);
    }


}
