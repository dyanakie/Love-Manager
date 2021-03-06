package com.lovemanager.app.service;

import com.lovemanager.app.data.base.CharacterRepository;
import com.lovemanager.app.models.basic.Item;
import com.lovemanager.app.service.base.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private CharacterRepository characterRepository;

    @Autowired
    public ItemServiceImpl(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    @Override
    public String getCurrentOutfit(int characterId) {

       return characterRepository.getCharacterById(characterId).getOutfit();

    }

    @Override
    public String getCurrentVehicle(int characterId) {

        return characterRepository.getCharacterById(characterId).getVehicle();
    }

    @Override
    public String getCurrentAccessorie(int characterId) {

        return characterRepository.getCharacterById(characterId).getAccessories();
    }



    @Override
    public void changeCurrentOutfit(int characterId, String outfit) {
        characterRepository.setOutfit(characterId, outfit);
    }

    @Override
    public void changeCurrentVehicle(int characterId, String vehicle) {

        characterRepository.setVehicle(characterId, vehicle);
    }

    @Override
    public void changeCurrentAccessorie(int characterId,String accessorie) {

        characterRepository.setAccessorie(characterId, accessorie);
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
        allItems.add(new Item("sweat-suit", "outfit", 1, 1, "physique", "pics/items/outfits/sweatSuit.jpg"));

        allItems.add(new Item("sunglasses", "accessories", 2, 2, "physique", "pics/items/accessories/sun-glasses.jpg"));
        allItems.add(new Item("trabant", "vehicles", 2, 2, "status", "pics/items/vehicles/greenTrabant.gif"));
        allItems.add(new Item("shirt", "outfit", 2, 2, "intelligence", "pics/items/outfits/t-shirt.jpg"));

        allItems.add(new Item("goldchain", "accessories", 3, 3, "physique", "pics/items/accessories/gold-chain.jpg"));
        allItems.add(new Item("normal", "vehicles", 3, 3, "status", "pics/items/vehicles/normal-car.png"));
        allItems.add(new Item("t-shirt", "outfit", 3, 3, "intelligence", "pics/items/outfits/shirt.png"));

        allItems.add(new Item("gold-teeth", "accessories", 4, 4, "physique", "pics/items/accessories/gold-teeth.jpeg"));
        allItems.add(new Item("red-sport", "vehicles", 4, 4, "status", "pics/items/vehicles/redSports.png"));
        allItems.add(new Item("casual-suit", "outfit", 4, 4, "intelligence", "pics/items/outfits/casual-suit.jpg"));

        allItems.add(new Item("golden-watch", "accessories", 5, 5, "physique", "pics/items/accessories/watch.jpg"));
        allItems.add(new Item("ferrari", "vehicles", 5, 5, "status", "pics/items/vehicles/ferary.jpg"));
        allItems.add(new Item("black-suit", "outfit", 5, 5, "intelligence", "pics/items/outfits/black-suit.png"));

        allItems.add(new Item("gentleman-pack", "accessories", 6, 6, "physique", "pics/items/accessories/gentleman-pack.png"));
        allItems.add(new Item("limousine", "vehicles", 6, 6, "status", "pics/items/vehicles/limo1.png"));
        allItems.add(new Item("vintage-suit", "outfit", 6, 6, "intelligence", "pics/items/outfits/vintage-suit.jpg"));

        return new ArrayList<Item>(allItems);
    }


}
