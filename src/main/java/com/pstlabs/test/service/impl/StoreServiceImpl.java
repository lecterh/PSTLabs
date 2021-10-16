package com.pstlabs.test.service.impl;

import com.pstlabs.test.entity.Profile;
import com.pstlabs.test.entity.Store;
import com.pstlabs.test.repository.StoreRepository;
import com.pstlabs.test.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store create(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store getById(Long id) {
        return storeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store update(Store store) {
        Store newStore;
        Optional<Store> oldStore = storeRepository.findById(store.getId());
        if (oldStore.isPresent()) {
            newStore = oldStore.get();
            newStore.setAddress(store.getAddress());
            newStore.setName(store.getName());

            storeRepository.save(newStore);
        } else {
            throw new RuntimeException("Can't find store");
        }
        return newStore;
    }

    @Override
    public void delete(Store store) {
        storeRepository.delete(store);
    }
}
