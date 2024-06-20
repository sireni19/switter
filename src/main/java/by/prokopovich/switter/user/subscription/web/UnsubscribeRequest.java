package by.prokopovich.switter.user.subscription.web;

import jakarta.validation.constraints.NotNull;

public record UnsubscribeRequest(@NotNull Long unfollowedId) {
}
