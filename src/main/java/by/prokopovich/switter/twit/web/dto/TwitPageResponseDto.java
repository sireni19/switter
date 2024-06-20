package by.prokopovich.switter.twit.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
@Getter
@Setter
public class TwitPageResponseDto {
    private long totalTwits;
    private boolean isFirstPage;
    private boolean isLastPage;
    private Collection<TwitResponseDto> twits;

    public TwitPageResponseDto(long totalTwits, boolean isFirstPage, boolean isLastPage, Collection<TwitResponseDto> twits) {
        this.totalTwits = totalTwits;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.twits = twits;
    }
}
