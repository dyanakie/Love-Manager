package com.lovemanager.app.service.base;

import com.lovemanager.app.models.Girl;

public interface NextChallengeService {

    Girl getNextGirl(int level);

    String getRandomType();

    int getRandomLevel(int level);

    String[] getUrlPresentationName();
}
