package by.prokopovich.switter.user.subscription.repository;

import by.prokopovich.switter.user.profile.model.UserProfile;
import by.prokopovich.switter.user.subscription.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    boolean existsByFollowedAndFollowed(UserProfile follower, UserProfile followed);
}
