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
    public boolean checkPassword(User user) {

        try{
           User newUser =  userRepository.getUserByName(user.getUsername());

            if(!newUser.getPassword().equals(user.getPassword())){
                return false;
            }


        }catch (NullPointerException n){

            createUser(user);
        }


        userRepository.setActiveUser(user);
        return true;

    }

    @Override
    public void createUser(User user){
        userRepository.createUser(user);

        userRepository.setActiveUser(user);
    }

    @Override
    public Active getActive() {
        return userRepository.getActive();
    }
}
