package by.prokopovich.switter.api.service;

import by.prokopovich.switter.api.model.UserAccountUserProfileApi;

import java.util.Optional;

public interface UserAccountUserProfileService {

    Optional<UserAccountUserProfileApi> currentUserAccountUserProfile();
}
