package com.lovemanager.app.data.base;

import com.lovemanager.app.models.Girl;

import java.util.List;

public interface GirlsRepository {

    String getUsedGirls(int characterId);

    void addUsedGirl(int characterId, String name);
}
