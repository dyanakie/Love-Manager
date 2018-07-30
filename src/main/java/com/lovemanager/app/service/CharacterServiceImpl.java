package com.lovemanager.app.service;

import com.lovemanager.app.data.Repository;
import com.lovemanager.app.models.Character;
import com.lovemanager.app.service.base.CharacterService;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

    private Repository repository;

    public CharacterServiceImpl(Repository repository){
        this.repository = repository;
    }

    @Override
    public Character getCharacterById(int id) {
        return repository.getCharacterById(id);
    }

}
