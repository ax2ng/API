//package com.API.schoolAPI.controllers.exControllers;
//
//import com.API.schoolAPI.model.ProfileModel;
//import com.API.schoolAPI.service.ProfileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/v1/api/profiles")
//public class ProfileApiController {
//    @Autowired
//    private final ProfileService profileService;
//
//
//    public ProfileApiController(ProfileService profileService) {
//        this.profileService = profileService;
//    }
//
//    @GetMapping
//    public List<ProfileModel> getAllProfiles() {
//        return profileService.findAllProfiles();
//    }
//
//    @GetMapping("/{id}")
//    public ProfileModel getProfileById(@PathVariable UUID id) {
//        return profileService.findProfileById(id);
//    }
//
//    @PostMapping
//    public ProfileModel createProfile(@RequestBody ProfileModel profile) {
//        return profileService.addProfile(profile);
//    }
//
//    @PutMapping("/{id}")
//    public ProfileModel updateProfile(@PathVariable UUID id, @RequestBody ProfileModel profile) {
//        profile.setId(id);
//        return profileService.updateProfile(profile);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProfile(@PathVariable UUID id) {
//        profileService.deleteProfile(id);
//    }
//}
