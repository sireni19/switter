package by.prokopovich.switter.user.subscription.repository;

import by.prokopovich.switter.user.profile.model.UserProfile;
import by.prokopovich.switter.user.subscription.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    boolean existsByFollowedAndFollowed(UserProfile follower, UserProfile followed);

    @Query(value = """
delete from switter.subscriptions where follower_id = :followerId and followed_id = :followedId
""",nativeQuery = true)
    void deleteByFollowedAndFollowed(@Param("followerId") Long followerId,@Param("followedId") Long followedId);
}
