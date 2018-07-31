package com.lovemanager.app.service;

import com.lovemanager.app.data.base.CharacterRepository;
import com.lovemanager.app.data.base.UserRepository;
import com.lovemanager.app.models.Girl;
import com.lovemanager.app.service.base.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlServiceImpl implements GirlService {

    private UserRepository userRepository;
    private CharacterRepository characterRepository;

    @Autowired
    public GirlServiceImpl(UserRepository userRepository, CharacterRepository characterRepository){
        this.userRepository = userRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public void saveGirl(Girl girl) {

        characterRepository.saveGirl(girl);

    }
}
