package by.prokopovich.switter.twit.mapper;

import by.prokopovich.switter.twit.model.Twit;
import by.prokopovich.switter.twit.web.dto.TwitResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TwitToResponseDtoMapper implements TwitToTwitResponseDtoMapper {
    @Override
    public TwitResponseDto map(Twit source) {
        TwitResponseDto response = TwitResponseDto.builder()
                .id(source.getId())
                .message(source.getMessage())
                .createdAt(source.getCreatedAt())
                .build();
        return response;
    }
}
