package by.prokopovich.switter.user.subscription.model;

import by.prokopovich.switter.user.profile.model.UserProfile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table(schema = "switter", name = "subscriptions")
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private UserProfile follower;
    @OneToOne
    private UserProfile followed;
    @CreatedDate
    @Column(nullable = false, updatable = false,name = "created_timestamp")
    private Instant createdTimestamp;

}
