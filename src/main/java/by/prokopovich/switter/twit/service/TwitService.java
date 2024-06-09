package by.prokopovich.switter.twit.service;

import by.prokopovich.switter.twit.model.Twit;
import by.prokopovich.switter.twit.web.dto.TwitEditRequest;
import by.prokopovich.switter.twit.web.dto.TwitRequestDto;
import by.prokopovich.switter.twit.web.dto.TwitResponseDto;

import java.util.Optional;

public interface TwitService {
    TwitResponseDto createTwit(TwitRequestDto twit);

    TwitResponseDto editTwit(TwitEditRequest edit);

}
