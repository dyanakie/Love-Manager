package com.lovemanager.app.service;

import com.lovemanager.app.data.base.CharacterRepository;
import com.lovemanager.app.data.base.UserRepository;
import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.User;
import com.lovemanager.app.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private CharacterRepository characterRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CharacterRepository characterRepository){
        this.userRepository = userRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void checkOrCreateUser(User user) {

        if(userRepository.checkForUser(user) == null){
            userRepository.createUser(user);
        }else{
            user = userRepository.getUserByName(user.getUsername());
        }

        userRepository.setActiveUser(user);

    }

    @Override
    public Active getActive() {
        return userRepository.getActive();
    }
}
