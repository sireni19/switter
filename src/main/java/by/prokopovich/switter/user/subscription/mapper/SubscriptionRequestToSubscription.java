package by.prokopovich.switter.user.subscription.mapper;

import by.prokopovich.switter.Mapper;
import by.prokopovich.switter.user.subscription.model.Subscription;
import by.prokopovich.switter.user.subscription.web.SubscriptionRequest;
import by.prokopovich.switter.user.subscription.web.UnsubscribeRequest;


public interface SubscriptionRequestToSubscription extends Mapper<Subscription, SubscriptionRequest> {
    Subscription map(UnsubscribeRequest request);
}
