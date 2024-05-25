package by.prokopovich.switter.twit.service;

import by.prokopovich.switter.twit.web.dto.TwitRequestDto;
import by.prokopovich.switter.twit.web.dto.TwitResponseDto;

public interface TwitService {
    TwitResponseDto createTwit(TwitRequestDto twit);
}
