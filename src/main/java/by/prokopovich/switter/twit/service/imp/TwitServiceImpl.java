package by.prokopovich.switter.twit.service.imp;

import by.prokopovich.switter.twit.mapper.TwitRequestDtoToTwitImpl;
import by.prokopovich.switter.twit.mapper.TwitToResponseDtoMapper;
import by.prokopovich.switter.twit.model.Twit;
import by.prokopovich.switter.twit.repository.TwitRepository;
import by.prokopovich.switter.twit.service.TwitService;
import by.prokopovich.switter.twit.web.dto.TwitRequestDto;
import by.prokopovich.switter.twit.web.dto.TwitResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TwitServiceImpl implements TwitService {
    private final TwitRequestDtoToTwitImpl mapperToTwit;
    private final TwitRepository repository;
    private final TwitToResponseDtoMapper mapperToDtoResponse;

    @Override
    public TwitResponseDto createTwit(TwitRequestDto dto) {
        Twit twit = mapperToTwit.map(dto);
        Twit saved = repository.save(twit);
        return mapperToDtoResponse.map(saved);
    }
}
