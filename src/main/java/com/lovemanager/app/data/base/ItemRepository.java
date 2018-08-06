package com.lovemanager.app.data.base;

import com.lovemanager.app.models.Item;

import java.util.List;

public interface ItemRepository {

    List<Item> getCurrentVehicle(int level);

    List<Item> getCurrentAccessorie(int level);

    List<Item> getCurrentOutfit(int level);
}
