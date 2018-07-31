package com.lovemanager.app.service.base;

import com.lovemanager.app.models.Character;

public interface CharacterService {

     Character getCharacterById(int id);

     void createCharacter();

}
