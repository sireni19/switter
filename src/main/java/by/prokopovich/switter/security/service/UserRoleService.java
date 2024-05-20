package by.prokopovich.switter.security.service;

import by.prokopovich.switter.security.model.UserRole;

import java.util.Optional;

public interface UserRoleService {

    Optional<UserRole>findUserRole();
}
