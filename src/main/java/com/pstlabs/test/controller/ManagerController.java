package com.pstlabs.test.controller;

import com.pstlabs.test.entity.Manager;
import com.pstlabs.test.entity.User;
import com.pstlabs.test.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/add")
    public Manager add(@RequestBody Manager manager) {
        return managerService.create(manager);
    }

    @GetMapping("{/id}")
    public Manager getById(@PathVariable Long id) {
        return managerService.getById(id);
    }

    @GetMapping
    public List<Manager> getAll() {
        return managerService.getAll();
    }

    @PatchMapping
    public Manager update(@RequestBody Manager manager) {
        return managerService.update(manager);
    }

    @DeleteMapping
    public void delete(@RequestBody Manager manager) {
        managerService.delete(manager);
    }
}
