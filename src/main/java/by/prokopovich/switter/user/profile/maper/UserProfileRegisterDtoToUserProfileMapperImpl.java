package by.prokopovich.switter.user.profile.maper;

import by.prokopovich.switter.api.model.UserAccountUserProfileApi;
import by.prokopovich.switter.api.service.UserAccountUserProfileService;
import by.prokopovich.switter.user.profile.model.UserProfile;
import by.prokopovich.switter.user.profile.web.dto.UserProfileRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileRegisterDtoToUserProfileMapperImpl implements UserProfileRegisterDtoToUserProfileMapper{

    private final UserAccountUserProfileService userAccountUserProfileService;

    @Override
    public UserProfile map(UserProfileRegisterDto source) {
        UserAccountUserProfileApi apiModel = userAccountUserProfileService.currentUserAccountUserProfile()
                .orElseThrow(()->new RuntimeException("Для добавления профиля пользователь должен быть авторизован"));
        UserProfile userProfile = UserProfile.builder()
                .id(apiModel.userAccountId())
                .nickname(source.getNickname())
                .imageLink(source.getImageLink())
                .build();
        return userProfile;
    }
}
