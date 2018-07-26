package com.lovemanager.app.service;


import com.lovemanager.app.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public List<User> getAll();

}
