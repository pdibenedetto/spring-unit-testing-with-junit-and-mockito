package com.in28minutes.unittesting.unittesting.controller;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private final ItemBusinessService itemBusinessService;

    public ItemController(ItemBusinessService itemBusinessService) {
        this.itemBusinessService = itemBusinessService;
    }

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        //Item item = businessService.retreiveHardcodedItem();

        return null;
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems() {
        return null; //businessService.retrieveAllItems();
    }

}
