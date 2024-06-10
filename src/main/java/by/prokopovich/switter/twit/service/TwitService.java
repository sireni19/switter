package by.prokopovich.switter.twit.service;

import by.prokopovich.switter.twit.model.Twit;
import by.prokopovich.switter.twit.web.dto.TwitEditRequest;
import by.prokopovich.switter.twit.web.dto.TwitRequestDto;
import by.prokopovich.switter.twit.web.dto.TwitResponseDto;
import by.prokopovich.switter.user.profile.model.UserProfile;

import java.util.Collection;
import java.util.Optional;

public interface TwitService {
    Twit findTwitById(Long id);

    TwitResponseDto createTwit(TwitRequestDto twit);

    TwitResponseDto editTwit(TwitEditRequest edit);

    void deleteTwit(Long id);

    Collection<TwitResponseDto> findTwits();

}
