package com.pstlabs.test.service.impl;

import com.pstlabs.test.entity.User;
import com.pstlabs.test.repository.UserRepository;
import com.pstlabs.test.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        User newUser;
        Optional<User> oldUser = userRepository.findById(user.getId());
        if (oldUser.isPresent()) {
            newUser = oldUser.get();
            newUser.setName(user.getName());
            newUser.setPassword(user.getPassword());
            newUser.setEmail(user.getEmail());
            userRepository.save(newUser);
        } else {
            throw new RuntimeException("Can't find user");
        }
        return newUser;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
