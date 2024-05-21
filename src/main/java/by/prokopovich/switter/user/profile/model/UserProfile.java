package by.prokopovich.switter.user.profile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "switter", name = "user_profiles")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserProfile {

    @Id
    private Long id;
    @Column(name = "nickname",unique = true,nullable = false)
    private String nickname;
    @Column(nullable = false)
    private String imageLink;

    public UserProfile() {
    }
}
