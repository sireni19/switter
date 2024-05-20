package by.prokopovich.switter.security.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(schema = "identity", name = "user_accounts")
@Getter
@Setter
@Builder
@AllArgsConstructor

public class UserAccount implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;


    @ManyToMany
    @JoinTable(schema = "identity",
            name ="user_accounts_roles",
            joinColumns = {@JoinColumn(name="user_account_id",referencedColumnName = "id")},
            inverseJoinColumns ={@JoinColumn(name = "user_role_id",referencedColumnName = "id")} )
    private Set<UserRole> authorities;

    public UserAccount() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (authorities);
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
