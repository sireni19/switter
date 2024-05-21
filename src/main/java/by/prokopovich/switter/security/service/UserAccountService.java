package by.prokopovich.switter.security.service;

import by.prokopovich.switter.security.web.dto.RegisterRequestDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserAccountService {

    void createUserAccount(RegisterRequestDto dto);

    Optional<UserDetails> findUserByUsername(String username);

}
