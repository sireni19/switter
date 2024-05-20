package by.prokopovich.switter.security.service;

import by.prokopovich.switter.security.web.dto.RegisterRequestDto;

public interface UserAccountService {

    void createUserAccount(RegisterRequestDto dto);
}
