package by.prokopovich.switter.twit.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Builder
@Getter//без геттеров json-сериализатор не сможет получить доступ к полям, чтобы сконвертировать объект этого типа в json-чик
public class TwitResponseDto {
    private Long id;
    private String message;
    private Instant createdAt;
}
