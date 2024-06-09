package by.prokopovich.switter.twit.model;

import by.prokopovich.switter.user.profile.model.UserProfile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;


@Entity
@Table(schema ="switter",name = "twits")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@RequiredArgsConstructor
@ToString
/*создастся слушатель, который следит, если Entity Twit был создан, он автоматически заполнит поле под@CreatedDate */
public class Twit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,updatable = false)
    private String message;
    @CreatedDate
    @Column(name = "created_timestamp",updatable = false)
    private Instant createdAt;
    @LastModifiedDate
    @Column(name = "modified_timestamp",nullable = false)
    private Instant modifiedAt;
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private UserProfile userProfile;

    public Twit(String message, UserProfile userProfile) {
        this.message = message;
        this.userProfile = userProfile;
    }
}
