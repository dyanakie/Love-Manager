package com.lovemanager.app.service.base;


import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void checkOrCreateUser(User user);

    Active getActive();

}
