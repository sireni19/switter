package by.prokopovich.switter.user.subscription.web;

import by.prokopovich.switter.user.subscription.service.SubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/subscribe")
    public void subscribe(@Valid @RequestBody final SubscriptionRequest request) {
        System.out.println(request);
        subscriptionService.subscribe(request);
    }
    @PostMapping("/unsubscribe")
    public void unsubscribe(@Valid @RequestBody final UnsubscribeRequest request) {
        subscriptionService.unsubscribe(request);
    }
}
