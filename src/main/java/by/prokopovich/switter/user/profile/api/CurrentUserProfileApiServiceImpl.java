package by.prokopovich.switter.user.profile.api;

import by.prokopovich.switter.api.model.UserAccountUserProfileApi;
import by.prokopovich.switter.api.service.UserAccountUserProfileServiceImpl;
import by.prokopovich.switter.user.profile.model.UserProfile;
import by.prokopovich.switter.user.profile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrentUserProfileApiServiceImpl implements CurrentUserProfileApiService {
    private final UserAccountUserProfileServiceImpl accountUserProfileService;
    private final UserProfileService userProfileService;

    @Override
    public UserProfile currentUserProfile() {
        UserAccountUserProfileApi currentUser = accountUserProfileService.currentUserAccountUserProfile().
                orElseThrow(() -> new RuntimeException("Пользователь должен быть атворизован в системе"));

        UserProfile profile=userProfileService.findUserProfileById(currentUser.userAccountId()).orElseThrow(() -> {
            String errorMessage = String.format("Профиля пользователя с id = %d в системе не существует", currentUser.userAccountId());
            return new RuntimeException(errorMessage);
        });
        return profile;
    }
}
