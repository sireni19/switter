package by.prokopovich.switter.security.service.impl;

import by.prokopovich.switter.security.maper.RegisterRequestToUserAccountMapper;
import by.prokopovich.switter.security.web.dto.RegisterRequestDto;
import by.prokopovich.switter.security.model.UserAccount;
import by.prokopovich.switter.security.repository.UserAccountRepository;
import by.prokopovich.switter.security.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final RegisterRequestToUserAccountMapper mapper;

    @Override
    public void createUserAccount(RegisterRequestDto dto) {
        if (userAccountRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Аккаунт с таким именем пользователя уже существует");
        }
        UserAccount account = mapper.map(dto);
        userAccountRepository.save(account);
    }

    @Override
    public Optional<UserDetails> findUserByUsername(String username) {
        return userAccountRepository.findByUsername(username);
    }

    @Override
    public Optional<UserAccount> findByUsername(String username, boolean flag) {
        return userAccountRepository.getUserAccountByUsername(username);
    }
}
