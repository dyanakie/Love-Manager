package com.lovemanager.app.service.base;

import com.lovemanager.app.models.Item;

public interface ItemService {

   Item getCurrentOutfit(int level);
   Item getCurrentVehicle(int level);
   Item getCurrentAccessorie(int level);
}
