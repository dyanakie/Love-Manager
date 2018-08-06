package com.lovemanager.app.service;

import com.lovemanager.app.data.base.ItemRepository;
import com.lovemanager.app.models.Item;
import com.lovemanager.app.service.base.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Override
    public Item getCurrentOutfit(int level) {
        return null;
    }

    @Override
    public Item getCurrentVehicle(int level) {
        return null;
    }

    @Override
    public Item getCurrentAccessorie(int level) {
        return null;
    }
}
