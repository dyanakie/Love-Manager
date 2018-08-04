package com.lovemanager.app.service.base;

import com.lovemanager.app.models.Girl;

import java.util.ArrayList;
import java.util.HashSet;

public interface GirlService {

    void saveGirl(Girl girl);

    ArrayList<Girl> loadAllGirls();

    HashSet<String> loadUsedGirls();

    void addUsedGirl(String name);
}
