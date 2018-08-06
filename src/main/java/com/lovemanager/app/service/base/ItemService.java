package com.lovemanager.app.service.base;

import com.lovemanager.app.models.Item;

import java.util.List;

public interface ItemService {

   Item getCurrentOutfit(int level);
   Item getCurrentVehicle(int level);
   Item getCurrentAccessorie(int level);

   List<Item> getAllVehicles(int level);
   List<Item> getAllOutfits(int level);
   List<Item> getAllAccessories(int level);
}
