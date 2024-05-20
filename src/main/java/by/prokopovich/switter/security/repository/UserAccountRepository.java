package by.prokopovich.switter.security.repository;

import by.prokopovich.switter.security.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
    boolean existsByUsername(String username);
}