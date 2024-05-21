package by.prokopovich.switter.security.repository;

import by.prokopovich.switter.security.model.UserAccount;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
    boolean existsByUsername(String username);
    /**
     @EntityGraph - решение, LazyInitializationException. Потому что Many-to-Many by default LazyInitialization
     и при загрузке UserDetails роли не подгружались, потому что к ним не обращались. Можно еще поставить fetchType EAGER
     */
    @EntityGraph(attributePaths = "authorities")
    Optional<UserDetails> findByUsername(String username);

    @EntityGraph(attributePaths = "authorities")
    Optional<UserAccount> getUserAccountByUsername(String username);
}
