package com.pstlabs.test.controller;

import com.pstlabs.test.entity.Profile;
import com.pstlabs.test.service.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/add")
    public Profile add(@RequestBody Profile profile) {
        return profileService.create(profile);
    }

    @GetMapping("/{id}")
    public Profile getById(@PathVariable Long id) {
        return profileService.getById(id);
    }

    @GetMapping
    public List<Profile> getAll() {
        return profileService.getAll();
    }

    @PatchMapping
    public Profile update(@RequestBody Profile profile) {
        return profileService.update(profile);
    }

    @DeleteMapping
    public void delete(@RequestBody Profile profile) {
        profileService.delete(profile);
    }
}
