package com.lovemanager.app.service.base;

import com.lovemanager.app.models.Character;

public interface CharacterService {

     Character getCharacterById(int id);

     void createCharacter();

     void deleteCurrentCharacter(int characterId);

     void changeIntelligence(int characterId, int amount);

     void changeStatus(int characterId, int amount);

     void changePhysique(int characterId, int amount);

}
