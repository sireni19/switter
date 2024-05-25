package by.prokopovich.switter.user.profile.service;

import by.prokopovich.switter.user.profile.model.UserProfile;
import by.prokopovich.switter.user.profile.web.dto.UserProfileRegisterDto;

import java.util.Optional;

public interface UserProfileService {

    void createUserProfile(UserProfileRegisterDto user);
    Optional<UserProfile> findUserProfileById(Long userProfileId);
}
