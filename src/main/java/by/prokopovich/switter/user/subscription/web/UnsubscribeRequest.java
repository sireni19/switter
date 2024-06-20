package by.prokopovich.switter.user.subscription.web;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UnsubscribeRequest{
    @NotNull
    private Long unfollowedId;
}
