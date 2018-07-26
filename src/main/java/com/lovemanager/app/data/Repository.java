package com.lovemanager.app.data;

import com.lovemanager.app.models.User;

import java.util.List;

public interface Repository {

    public List<User> getAll();

    public User checkOrCreateUser(User user);

    public void createUser(User user);
}
