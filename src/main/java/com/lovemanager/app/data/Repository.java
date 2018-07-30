package com.lovemanager.app.data;

import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.Character;
import com.lovemanager.app.models.User;

import java.util.List;

public interface Repository {

    List<User> getAll();

    User checkForUser(User user);

    void createUser(User user);

    List<Character> getAllCharacters();

    void setActiveUser(User user);

    Active getActive();

    User getUserByName(String name);

    void createCharacter(User user);

    void saveCharacterIdForUser(User user);

    Character getCharacterById(int id);

}
