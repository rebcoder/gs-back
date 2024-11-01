package in.rebcoder.gs_back.controllers;


import in.rebcoder.gs_back.models.Profile;
import in.rebcoder.gs_back.models.User;
import in.rebcoder.gs_back.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/create")
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.createProfile(profile);
    }

    @GetMapping("/user/{userId}")
    public Profile getProfileByUser(@PathVariable Long userId) {
        User user = new User(); // Fetch user by ID or however you implement user retrieval
        user.setId(userId);
        return profileService.getProfileByUser(user);
    }

    @PutMapping("/{id}")
    public Profile updateProfile(@PathVariable Long id, @RequestBody Profile updatedProfile) {
        return profileService.updateProfile(id, updatedProfile);
    }
}