package by.prokopovich.switter.twit.service;

import by.prokopovich.switter.twit.model.Twit;
import by.prokopovich.switter.twit.web.dto.TwitEditRequest;
import by.prokopovich.switter.twit.web.dto.TwitFindRequest;
import by.prokopovich.switter.twit.web.dto.TwitRequestDto;
import by.prokopovich.switter.twit.web.dto.TwitResponseDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
@Validated
public interface TwitService {
    Twit findTwitById(Long id);

    TwitResponseDto createTwit(TwitRequestDto twit);

    TwitResponseDto editTwit(TwitEditRequest edit);

    void deleteTwit(Long id);

    Collection<TwitResponseDto> findTwits(@Valid TwitFindRequest request);

}
