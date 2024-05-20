package by.prokopovich.switter.security.service;

import by.prokopovich.switter.security.model.UserRole;
import by.prokopovich.switter.security.repository.UserRoleRepository;
import by.prokopovich.switter.security.service.impl.UserRoleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserRoleServiceImplTest {
    @Mock
    private UserRoleRepository userRoleRepository;
    @InjectMocks
    private UserRoleServiceImpl userRoleService;

    @Test
    void testFindUserRole() {
        // Arrange
        UserRole userRole = new UserRole("ROLE_USER");
        when(userRoleRepository.findByAuthority("ROLE_USER")).thenReturn(Optional.of(userRole));

        // Act
        Optional<UserRole> result = userRoleService.findUserRole();

        // Assert
        assertEquals(Optional.of(userRole), result);
    }

    @Test
    void testFindUserRoleNotFound() {
        // Arrange
        when(userRoleRepository.findByAuthority("ROLE_USER")).thenReturn(Optional.empty());

        // Act
        Optional<UserRole> result = userRoleService.findUserRole();

        // Assert
        assertEquals(Optional.empty(), result);
    }

}