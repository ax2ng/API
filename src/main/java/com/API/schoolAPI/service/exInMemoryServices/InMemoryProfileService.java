//package com.API.schoolAPI.service;
//
//import com.API.schoolAPI.model.ProfileModel;
//import com.API.schoolAPI.repository.ProfileRepository;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class InMemoryProfileService implements ProfileService {
//    private final ProfileRepository profileRepository;
//
//    public InMemoryProfileService(ProfileRepository profileRepository) {
//        this.profileRepository = profileRepository;
//    }
//
//    @Override
//    public List<ProfileModel> findAllProfiles() {
//        return profileRepository.findAll(Sort.by("id"));
//    }
//
//    @Override
//    public ProfileModel findProfileById(UUID id) {
//        return profileRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public ProfileModel addProfile(ProfileModel profile) {
//        return profileRepository.save(profile);
//    }
//
//    @Override
//    public ProfileModel updateProfile(ProfileModel profile) {
//        if (profileRepository.existsById(profile.getId())) {
//            return profileRepository.save(profile);
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteProfile(UUID id) {
//        if (profileRepository.existsById(id)) {
//            profileRepository.deleteById(id);
//        }
//    }
//
//}
