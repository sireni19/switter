package by.prokopovich.switter.security.maper;

import by.prokopovich.switter.security.model.UserAccount;
import by.prokopovich.switter.security.model.UserRole;
import by.prokopovich.switter.security.service.UserRoleService;
import by.prokopovich.switter.security.web.dto.RegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class RegisterRequestToUserAccountMapperImpl implements RegisterRequestToUserAccountMapper {

    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserAccount map(RegisterRequestDto dto) {
        UserRole userRole = userRoleService.findUserRole().orElseThrow(() -> new RuntimeException("Такая роль не найдена"));
        UserAccount userAccount = UserAccount.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .authorities(Set.of(userRole))
                .build();
        return userAccount;
    }
}
