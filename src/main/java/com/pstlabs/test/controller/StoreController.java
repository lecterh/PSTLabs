package com.pstlabs.test.controller;

import com.pstlabs.test.entity.Store;
import com.pstlabs.test.entity.User;
import com.pstlabs.test.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/add")
    public Store add(@RequestBody Store store) {
        return storeService.create(store);
    }

    @GetMapping("/{id}")
    public Store getById(@PathVariable Long id) {
        return storeService.getById(id);
    }

    @GetMapping
    public List<Store> getAll() {
        return storeService.getAll();
    }

    @PatchMapping
    public Store update(@RequestBody Store store) {
        return storeService.update(store);
    }

    @DeleteMapping
    public void delete(@RequestBody Store store) {
        storeService.delete(store);
    }
}
