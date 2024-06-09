package by.prokopovich.switter.twit.mapper;

import by.prokopovich.switter.twit.model.Twit;
import by.prokopovich.switter.twit.repository.TwitRepository;
import by.prokopovich.switter.twit.web.dto.TwitEditRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TwitEditRequestToTwitMapperImpl implements TwitEditRequestToTwitMapper {
    private final TwitRepository twitRepository;

    @Override
    public Twit map(TwitEditRequest source) {
        Twit currentTwit = twitRepository.findById(source.getId()).orElseThrow(() -> {
            String errorMessage = String.format("Твит с id =%d не существует", source.getId());
            return new RuntimeException(errorMessage);
        });
        currentTwit.setMessage(source.getUpdatedMessage());
        return currentTwit;
    }
}
