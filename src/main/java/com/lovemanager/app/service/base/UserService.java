package com.lovemanager.app.service.base;


import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getAll();

    boolean checkPassword(User user);

    Active getActive();

    void createUser(User user);

}
