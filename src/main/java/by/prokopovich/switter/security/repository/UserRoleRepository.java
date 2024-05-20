package by.prokopovich.switter.security.repository;

import by.prokopovich.switter.security.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findByAuthority(String authority);
}
