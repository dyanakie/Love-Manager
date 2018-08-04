package com.lovemanager.app.service.base;

import com.lovemanager.app.models.Girl;

public interface NextChallengeService {

    Girl getNextGirl();

    String[] getUrlPresentationName();

    int generateGirlLevel();
}
