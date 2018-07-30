package com.lovemanager.app.data;

import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.Character;
import com.lovemanager.app.models.User;

import java.util.List;

public interface Repository {

    public List<User> getAll();

    public User checkForUser(User user);

    public void createUser(User user);

    public List<Character> getAllCharacters();

    public void setActiveUser(User user);

    public Active getActive();

    public User getUserByName(String name);

    public void createCharacter(User user);
}
