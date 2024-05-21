package by.prokopovich.switter.api.service;

import by.prokopovich.switter.api.model.UserAccountUserProfileApi;
import by.prokopovich.switter.security.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Этот класс связующее звено между security.UserAccount и user.UserProfile
 */
@Service
@RequiredArgsConstructor
public class UserAccountUserProfileServiceImpl implements UserAccountUserProfileService {

    private final UserAccountService userAccountService;

    /**
     * Этот метод получает username из объекта Authentication после авторизации. По полученному username
     * находится UserAccount, что значит, что пользователь зарегистрирован. Один UserAccount дает
     * свой id одному UserProfile, поэтому, используя связующее звено UserAccountUserProfileApi,
     * мы сможем передать id от UserAccount в создаваемый UserProfile.
     * Схема [ищем UserAccount по username из Authentication]-->[UserAccountUserProfileApi]-->[создаем UserProfile по id из UserAccountUserProfileApi]
     */
    @Override
    public Optional<UserAccountUserProfileApi> currentUserAccountUserProfile() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }
        String username = authentication.getName();
        // в метод map входит объект типа UserAccount а выходит новосозданный объект типа UserAccountUserProfileApi
        return userAccountService.findByUsername(username,true).map(userAccount->new UserAccountUserProfileApi(userAccount.getId()));
    }
}
