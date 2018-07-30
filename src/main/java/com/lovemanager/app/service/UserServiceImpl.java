package com.lovemanager.app.service;

import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.User;
import com.lovemanager.app.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private com.lovemanager.app.data.Repository repository;

    @Autowired
    public UserServiceImpl(com.lovemanager.app.data.Repository repository){
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void checkOrCreateUser(User user) {

        if(repository.checkForUser(user) == null){
            repository.createUser(user);
        }else{
            user = repository.getUserByName(user.getUsername());
        }

        repository.setActiveUser(user);

        repository.createCharacter(user);

        repository.saveCharacterIdForUser(user);

    }

    @Override
    public Active getActive() {
        return repository.getActive();
    }
}
