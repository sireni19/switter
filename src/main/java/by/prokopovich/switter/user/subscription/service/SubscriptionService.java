package by.prokopovich.switter.user.subscription.service;

import by.prokopovich.switter.user.subscription.model.Subscription;
import by.prokopovich.switter.user.subscription.web.SubscriptionRequest;
import by.prokopovich.switter.user.subscription.web.UnsubscribeRequest;

public interface SubscriptionService {
    void subscribe(SubscriptionRequest request);

    void unsubscribe(UnsubscribeRequest request);

    boolean existsSubscription(Subscription subscription);
}
