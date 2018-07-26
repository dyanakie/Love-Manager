package com.lovemanager.app.service;

import com.lovemanager.app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private com.lovemanager.app.data.Repository repository;

    public UserServiceImpl(com.lovemanager.app.data.Repository repository){
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void checkOrCreateUser(User user) {

        if(repository.checkOrCreateUser(user) == null){
            repository.createUser(user);
        }

    }
}
