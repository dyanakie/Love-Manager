package com.lovemanager.app.service.base;


import com.lovemanager.app.models.Active;
import com.lovemanager.app.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public List<User> getAll();

    public void checkOrCreateUser(User user);

    public Active getActive();

}
