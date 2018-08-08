package com.lovemanager.app.service;

import com.lovemanager.app.data.base.ItemRepository;
import com.lovemanager.app.models.basic.Item;
import com.lovemanager.app.service.base.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
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
        return getAllItems().stream()
                .filter(x -> x.getLevel() <= level)
                .filter(x -> x.getType().equals("vehicles"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> getAllOutfits(int level) {

        return getAllItems().stream()
                .filter(x -> x.getLevel() <= level)
                .filter(x -> x.getType().equals("outfit"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> getAllAccessories(int level) {
        return getAllItems().stream()
                .filter(x -> x.getLevel() <= level)
                .filter(x -> x.getType().equals("accessories"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> getAllItems() {

        List<Item> allItems = new LinkedList<>();

        allItems.add(new Item("glasses", "accessories", 1, 1, "intelligence", "pics/items/accessories/glasses.png"));
        allItems.add(new Item("bicycle", "vehicles", 1, 1, "status", "pics/items/vehicles/bicycle.png"));
        allItems.add(new Item("shirt", "outfit", 1, 1, "physique", "pics/items/outift/shirt.png"));

        return new ArrayList<Item>(allItems);
    }


}
