package com.lovemanager.app.service.base;

import com.lovemanager.app.models.basic.Item;

import java.util.List;

public interface ItemService {

   String getCurrentOutfit(int characterId);
   String getCurrentVehicle(int characterId);
   String getCurrentAccessorie(int characterId);

   void changeCurrentOutfit(int characterId, String outfit);
   void changeCurrentVehicle(int characterId, String vehicle);
   void changeCurrentAccessorie(int characterId, String accessorie);

   List<Item> getAllVehicles(int level);
   List<Item> getAllOutfits(int level);
   List<Item> getAllAccessories(int level);

   List<Item> getAllItems();
}
