package com.lovemanager.app.service;

import com.lovemanager.app.data.base.CharacterRepository;
import com.lovemanager.app.data.base.UserRepository;
import com.lovemanager.app.models.Character;
import com.lovemanager.app.models.User;
import com.lovemanager.app.service.base.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

    private UserRepository userRepository;
    private CharacterRepository characterRepository;

    @Autowired
    public CharacterServiceImpl(UserRepository userRepository, CharacterRepository characterRepository){
        this.userRepository = userRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public Character getCharacterById(int id) {
        return characterRepository.getCharacterById(id);
    }

    @Override
    public void createCharacter(){

        User user = userRepository.getUserByName(userRepository.getActive().getName());

        characterRepository.createCharacter(user);

        characterRepository.saveCharacterIdForUser(user);
    }

    @Override
    public void deleteCurrentCharacter(int characterId) {

        characterRepository.deleteActiveCharacter(characterId);
    }

}
