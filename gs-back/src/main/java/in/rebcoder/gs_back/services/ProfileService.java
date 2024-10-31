package in.rebcoder.gs_back.services;

import in.rebcoder.gs_back.models.Profile;
import in.rebcoder.gs_back.models.User;

public interface ProfileService {
    Profile createProfile(Profile profile);

    Profile getProfileByUser(User user);

    Profile updateProfile(Long id, Profile updatedProfile);
}
