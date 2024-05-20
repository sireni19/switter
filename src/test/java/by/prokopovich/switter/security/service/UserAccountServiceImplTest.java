package by.prokopovich.switter.security.service;

import by.prokopovich.switter.security.maper.RegisterRequestToUserAccountMapper;
import by.prokopovich.switter.security.model.UserAccount;
import by.prokopovich.switter.security.model.UserRole;
import by.prokopovich.switter.security.repository.UserAccountRepository;
import by.prokopovich.switter.security.service.impl.UserAccountServiceImpl;
import by.prokopovich.switter.security.web.dto.RegisterRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceImplTest {
    @Mock
    private UserAccountRepository userAccountRepository;

    @Mock
    private RegisterRequestToUserAccountMapper mapper;

    @InjectMocks
    private UserAccountServiceImpl userAccountService;

    private final UserAccount userAccount=new UserAccount();

    @BeforeEach
    void setUp() {
        userAccount.setUsername("username");
        userAccount.setPassword("pseudoencodedpassword");
        userAccount.setAuthorities(Set.of(new UserRole("ROLE_USER")));
    }

    @Test
    void testCreateUserAccount() {
        // Arrange
        RegisterRequestDto requestDto = new RegisterRequestDto("username", "password");

        when(userAccountRepository.existsByUsername("username")).thenReturn(false);
        when(mapper.map(requestDto)).thenReturn(userAccount);

        // Act
        userAccountService.createUserAccount(requestDto);

        // Assert
        verify(userAccountRepository, times(1)).save(userAccount);
        verify(mapper, times(1)).map(requestDto);
    }

    @Test
    void testCreateUserAccountWithExistingUsername() {
        // Arrange
        RegisterRequestDto requestDto = getRegisterRequestDto();
        when(userAccountRepository.existsByUsername("username")).thenReturn(true);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> userAccountService.createUserAccount(requestDto));
        verify(userAccountRepository, Mockito.never()).save(any());
    }

    private static RegisterRequestDto getRegisterRequestDto() {
        RegisterRequestDto requestDto = new RegisterRequestDto("username", "password");
        return requestDto;
    }
}


