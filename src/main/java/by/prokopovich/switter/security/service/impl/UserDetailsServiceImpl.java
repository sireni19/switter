package by.prokopovich.switter.security.service.impl;

import by.prokopovich.switter.security.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Необходим, чтобы пользователя, при авторизации, приложение искало в БД
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountService userAccountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAccountService.findUserByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Неверные учетные данные пользователя"));
    }
}
