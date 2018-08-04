package com.lovemanager.app.data.base;

import com.lovemanager.app.models.Character;
import com.lovemanager.app.models.Girl;
import com.lovemanager.app.models.User;

import java.util.List;

public interface CharacterRepository {

    List<Character> getAllCharacters();

    void createCharacter(User user);

    void saveCharacterIdForUser(User user);

    Character getCharacterById(int id);

    void saveGirl(Girl girl);

    Girl getActiveGirl();

    void levelUp(int characterId);

    void deleteActiveCharacter(int characterId);

    void changeIntelligence(int characterId, int amount);

    void changeStatus(int characterId, int amount);

    void changePhysique(int characterId, int amount);
}
