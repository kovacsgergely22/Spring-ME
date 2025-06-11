package org.me.bookstore.service;

import org.me.bookstore.model.StorePlace;
import org.me.bookstore.persist.StorePlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorePlaceService {

    @Autowired
    private StorePlaceRepository storePlaceRepository;

    public List<StorePlace> getAllStorePlaces(){
        return storePlaceRepository.findAll();
    }

    public StorePlace saveStorePlace(StorePlace storePlace){
        return storePlaceRepository.save(storePlace);
    }
}
