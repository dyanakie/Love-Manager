package com.lovemanager.app.data.base;

import com.lovemanager.app.models.Character;
import com.lovemanager.app.models.User;

import java.util.List;

public interface CharacterRepository {

    List<Character> getAllCharacters();

    void createCharacter(User user);

    void saveCharacterIdForUser(User user);

    Character getCharacterById(int id);
}
