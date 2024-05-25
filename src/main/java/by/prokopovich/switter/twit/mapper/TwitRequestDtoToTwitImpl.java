package by.prokopovich.switter.twit.mapper;

import by.prokopovich.switter.twit.model.Twit;
import by.prokopovich.switter.twit.web.dto.TwitRequestDto;
import by.prokopovich.switter.user.profile.api.CurrentUserProfileApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TwitRequestDtoToTwitImpl implements TwitRequestDtoToTwitMapper {
    private final CurrentUserProfileApiService service;

    @Override
    public Twit map(TwitRequestDto source) {
        Twit twit = new Twit(source.getText(), service.currentUserProfile());
        return twit;
    }
}
