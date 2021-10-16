package com.pstlabs.test.service.impl;

import com.pstlabs.test.entity.Profile;
import com.pstlabs.test.entity.User;
import com.pstlabs.test.repository.ProfileRepository;
import com.pstlabs.test.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile getById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile update(Profile profile) {
        Profile newProfile;
        Optional<Profile> oldProfile = profileRepository.findById(profile.getId());
        if (oldProfile.isPresent()) {
            newProfile = oldProfile.get();
            newProfile.setFirstName(profile.getFirstName());
            newProfile.setLastName(profile.getLastName());
            newProfile.setAddress(profile.getAddress());
            profileRepository.save(newProfile);
        } else {
            throw new RuntimeException("Can't find profile");
        }
        return newProfile;
    }

    @Override
    public void delete(Profile profile) {
        profileRepository.delete(profile);
    }
}
