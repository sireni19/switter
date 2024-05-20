package by.prokopovich.switter.security.service.impl;

import by.prokopovich.switter.security.model.UserRole;
import by.prokopovich.switter.security.repository.UserRoleRepository;
import by.prokopovich.switter.security.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Override
    public Optional<UserRole> findUserRole() {
        return userRoleRepository.findByAuthority("ROLE_USER");
    }


}
