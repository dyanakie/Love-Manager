package com.lovemanager.app.data.base;

import com.lovemanager.app.models.basic.Item;

import java.util.List;

public interface ItemRepository {

    List<Item> getAllItems();

    int getCurrentVehicle(int characterId);
    int getCurrentOutfit(int characterId);
    int getCurrentAccessorie(int characterId);

    void setCurrentVehicle(int id);
    void setCurrentOutfit(int id);
    void setCurrentAccessorie(int id);

}
