package com.lovemanager.app.service;

import com.lovemanager.app.data.base.ItemRepository;
import com.lovemanager.app.models.Item;
import com.lovemanager.app.service.base.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Item> getAllVehicles(int level) {
        return itemRepository.getAllItems().stream()
                .filter(x -> x.getLevel() <= level)
                .filter(x -> x.getType().equals("vehicles"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> getAllOutfits(int level) {

        return itemRepository.getAllItems().stream()
                .filter(x -> x.getLevel() <= level)
                .filter(x -> x.getType().equals("outfit"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> getAllAccessories(int level) {
        return itemRepository.getAllItems().stream()
                .filter(x -> x.getLevel() <= level)
                .filter(x -> x.getType().equals("accessories"))
                .collect(Collectors.toList());
    }
}
