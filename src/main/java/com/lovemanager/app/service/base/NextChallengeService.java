package com.lovemanager.app.service.base;

import com.lovemanager.app.models.Girl;

public interface NextChallengeService {

    public Girl getNextGirl(int level);

    public String getRandomType();

    public int getRandomLevel(int level);

    public String[] getUrlPresentationName();
}
