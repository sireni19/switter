package by.prokopovich.switter.user.profile.service;

import by.prokopovich.switter.user.profile.web.dto.UserProfileRegisterDto;

public interface UserProfileService {

    void createUserProfile(UserProfileRegisterDto user);
}
