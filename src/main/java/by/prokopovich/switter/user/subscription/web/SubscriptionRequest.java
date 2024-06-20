package by.prokopovich.switter.user.subscription.web;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SubscriptionRequest {

    @NotNull
    private Long followedId;
}
