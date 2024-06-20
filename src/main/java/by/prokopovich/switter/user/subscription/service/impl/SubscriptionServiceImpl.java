package by.prokopovich.switter.user.subscription.service.impl;

import by.prokopovich.switter.user.subscription.mapper.SubscriptionRequestToSubscription;
import by.prokopovich.switter.user.subscription.model.Subscription;
import by.prokopovich.switter.user.subscription.repository.SubscriptionRepository;
import by.prokopovich.switter.user.subscription.service.SubscriptionService;
import by.prokopovich.switter.user.subscription.web.SubscriptionRequest;
import by.prokopovich.switter.user.subscription.web.UnsubscribeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionRequestToSubscription mapper;

    @Transactional
    @Override
    public void subscribe(SubscriptionRequest request) {
        Subscription subscription = mapper.map(request);
        if (subscription.getFollower().equals(subscription.getFollowed())) {
            throw new RuntimeException("Подписка на самого себя запрещена");
        }
        if (subscriptionRepository.findById(subscription.getFollowed().getId()).isPresent()) {
            throw new RuntimeException(String.format("Вы уже подписаны на %s", subscription.getFollowed().getNickname()));
        }
        subscriptionRepository.save(subscription);
    }

    @Transactional
    @Override
    public void unsubscribe(UnsubscribeRequest request) {
        Subscription subscription = mapper.map(request);
        subscriptionRepository.deleteByFollowedAndFollowed(subscription.getFollower().getId(), subscription.getFollowed().getId());
    }

    @Override
    public boolean existsSubscription(Subscription subscription) {
        return subscriptionRepository.existsByFollowedAndFollowed(subscription.getFollower(), subscription.getFollowed());
    }
}
