package com.lovemanager.app.service.base;

import com.lovemanager.app.models.Girl;

public interface NextChallengeService {

    Girl getNextGirl();

    String getRandomType();

    String[] getUrlPresentationName();
}
