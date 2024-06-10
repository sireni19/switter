package by.prokopovich.switter.twit.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;


public record TwitFindRequest(
        @Min(0)
        int page,
        @Min(25)@Max(100)
        int limit) {
}
