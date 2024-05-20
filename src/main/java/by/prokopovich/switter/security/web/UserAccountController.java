package by.prokopovich.switter.security.web;

import by.prokopovich.switter.security.web.dto.RegisterRequestDto;
import by.prokopovich.switter.security.service.UserAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
@Slf4j
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@RequestBody @Valid RegisterRequestDto dto) {
        log.info("Registering account: {}", dto);
        userAccountService.createUserAccount(dto);
    }
}
