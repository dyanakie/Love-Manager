package com.lovemanager.app.services;

import com.lovemanager.app.data.base.CharacterRepository;
import com.lovemanager.app.data.base.UserRepository;
import com.lovemanager.app.models.User;
import com.lovemanager.app.service.UserServiceImpl;
import com.lovemanager.app.service.base.UserService;
import org.junit.*;
import org.mockito.Mockito;

import java.util.*;


public class UserServiceImplTests1 {

    @Test
    public void Check_Password_Correctly_Compares_Input_Pass_With_Database(){

        UserRepository mockRepository = Mockito.mock(UserRepository.class);
        CharacterRepository mockCharacterRepository = Mockito.mock(CharacterRepository.class);

        User newUser = new User();

        newUser.setPassword("password");

        Mockito.when(mockRepository.checkForUser(newUser))
                .thenReturn(newUser);

        UserService userService = new UserServiceImpl(mockRepository, mockCharacterRepository);

        Assert.assertTrue(userService.checkPassword(newUser));
    }


}
