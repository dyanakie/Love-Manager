package com.lovemanager.app.service.base;

import com.lovemanager.app.models.Girl;

import java.util.ArrayList;
import java.util.List;

public interface NextChallengeService {

    Girl getNextGirl();

    int generateGirlLevel();

    List<Girl> getUnusedGirls();

    Girl getGirl();

}
