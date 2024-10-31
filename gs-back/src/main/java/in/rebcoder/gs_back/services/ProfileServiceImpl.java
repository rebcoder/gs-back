package in.rebcoder.gs_back.services;

import in.rebcoder.gs_back.models.Profile;
import in.rebcoder.gs_back.models.User;
import in.rebcoder.gs_back.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    private ProfileRepository profileRepository;

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile getProfileByUser(User user) {
        return profileRepository.findByUser(user);
    }

    public Profile updateProfile(Long id, Profile updatedProfile) {
        Profile existingProfile = profileRepository.findById(id).orElseThrow();
        existingProfile.setBio(updatedProfile.getBio());
        existingProfile.setRating(updatedProfile.getRating());
        return profileRepository.save(existingProfile);
    }
}
