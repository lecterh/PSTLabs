package com.pstlabs.test.service.impl;

import com.pstlabs.test.entity.Manager;
import com.pstlabs.test.entity.User;
import com.pstlabs.test.repository.ManagerRepository;
import com.pstlabs.test.repository.UserRepository;
import com.pstlabs.test.service.ManagerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public Manager create(Manager user) {
        return managerRepository.save(user);
    }

    @Override
    public Manager getById(Long id) {
        return managerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Manager> getAll() {
        return managerRepository.findAll();
    }

    @Override
    public Manager update(Manager manager) {
        Manager newManager;
        Optional<Manager> oldManager = managerRepository.findById(manager.getId());
        if (oldManager.isPresent()) {
            newManager = oldManager.get();
            newManager.setName(manager.getName());
            managerRepository.save(newManager);
        } else {
            throw new RuntimeException("Can't find profile");
        }
        return newManager;
    }

    @Override
    public void delete(Manager manager) {
        managerRepository.delete(manager);
    }
}
