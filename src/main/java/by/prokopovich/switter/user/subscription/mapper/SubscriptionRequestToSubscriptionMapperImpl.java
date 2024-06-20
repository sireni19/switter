package by.prokopovich.switter.user.subscription.mapper;

import by.prokopovich.switter.user.profile.api.CurrentUserProfileApiService;
import by.prokopovich.switter.user.profile.service.UserProfileService;
import by.prokopovich.switter.user.subscription.model.Subscription;
import by.prokopovich.switter.user.subscription.web.SubscriptionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionRequestToSubscriptionMapperImpl implements SubscriptionRequestToSubscription{
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final UserProfileService userProfileService;

    @Override
    public Subscription map(SubscriptionRequest source) {
      Subscription subscription=new Subscription();
      subscription.setFollower(currentUserProfileApiService.currentUserProfile());
      subscription.setFollowed(userProfileService.findUserProfileById((source.getFollowedId())).get());
      return subscription;
    }
}
