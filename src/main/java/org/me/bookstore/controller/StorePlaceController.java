package org.me.bookstore.controller;

import jakarta.annotation.PostConstruct;
import org.me.bookstore.model.StorePlace;
import org.me.bookstore.service.StorePlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storeplaces")
public class StorePlaceController {

    @Autowired
    private StorePlaceService storePlaceService;

    @GetMapping
    public List<StorePlace> getAllStorePlaces(){
        return storePlaceService.getAllStorePlaces();
    }

    @GetMapping("/{id}")
    public StorePlace getStorePlaceById(@PathVariable Long id){
        return storePlaceService.getStorePlaceById(id);
    }

    @PostMapping
    public StorePlace createStorePlace(@RequestBody StorePlace storePlace){
        return storePlaceService.saveStorePlace(storePlace);
    }

    @PutMapping("/{id}")
    public StorePlace updateStorePlace(@PathVariable Long id, @RequestBody StorePlace storePlace){
        storePlace.setId(id);
        return storePlaceService.updateStorePlace(storePlace);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStorePlace(@PathVariable Long id){
        storePlaceService.deleteStorePlace(id);
    }

    @PostConstruct
    public void init(){
        StorePlace storePlace = new StorePlace("Miskolci Könyváruház", 3500, "Miskolc", "Szeles utca 2");
        storePlaceService.saveStorePlace(storePlace);
        StorePlace storePlace1 = new StorePlace("Budapesti Könyváruház", 1100, "Budapest", "Kerepesi út 1");
        storePlaceService.saveStorePlace(storePlace1);
        StorePlace storePlace2 = new StorePlace("Debreceni Könyváruház", 4000, "Debrecen", "Sas utca 1.");
        storePlaceService.saveStorePlace(storePlace2);
    }
}
