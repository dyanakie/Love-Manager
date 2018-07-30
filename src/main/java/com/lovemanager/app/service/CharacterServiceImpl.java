package com.lovemanager.app.service;

import com.lovemanager.app.data.Repository;
import com.lovemanager.app.service.base.CharacterService;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

    private Repository repository;

    public CharacterServiceImpl(Repository repository){
        this.repository = repository;
    }

    @Override
    public int getIntelligence() {
        return 0;
    }

    @Override
    public int getPhysique() {
        return 0;
    }

    @Override
    public int getKnowledge() {
        return 0;
    }
}
