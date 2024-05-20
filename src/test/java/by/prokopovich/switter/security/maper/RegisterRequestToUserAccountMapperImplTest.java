package by.prokopovich.switter.security.maper;

import by.prokopovich.switter.security.model.UserAccount;
import by.prokopovich.switter.security.model.UserRole;
import by.prokopovich.switter.security.service.UserRoleService;
import by.prokopovich.switter.security.web.dto.RegisterRequestDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class RegisterRequestToUserAccountMapperImplTest {
    @Mock
    private UserRoleService userRoleService;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private RegisterRequestToUserAccountMapperImpl registerRequestToUserAccountMapper;


    @Test
    void map_ReturnsUserAccount() {
        RegisterRequestDto dto = new RegisterRequestDto("testuser", "testpassword");
        UserRole role = new UserRole("ROLE_USER");
        when(userRoleService.findUserRole()).thenReturn(Optional.of(role));
        when(passwordEncoder.encode(dto.getPassword())).thenReturn("encodedpassword");

        UserAccount userAccount = registerRequestToUserAccountMapper.map(dto);
        assertEquals(dto.getUsername(), userAccount.getUsername());
        assertEquals("encodedpassword", userAccount.getPassword());
        assertEquals(Set.of(role), userAccount.getAuthorities());
    }
    @Test
    void map_ThrowRuntimeException(){
        RegisterRequestDto dto = new RegisterRequestDto("testuser", "testpassword");

        when(userRoleService.findUserRole()).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> registerRequestToUserAccountMapper.map(dto));
        assertEquals("Такая роль не найдена", exception.getMessage());

    }
}