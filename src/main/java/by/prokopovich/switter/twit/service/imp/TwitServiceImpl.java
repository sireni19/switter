package by.prokopovich.switter.twit.service.imp;

import by.prokopovich.switter.twit.mapper.TwitEditRequestToTwitMapper;
import by.prokopovich.switter.twit.mapper.TwitRequestDtoToTwitImpl;
import by.prokopovich.switter.twit.mapper.TwitToTwitResponseDtoMapper;
import by.prokopovich.switter.twit.model.Twit;
import by.prokopovich.switter.twit.repository.TwitRepository;
import by.prokopovich.switter.twit.service.TwitService;
import by.prokopovich.switter.twit.web.dto.TwitEditRequest;
import by.prokopovich.switter.twit.web.dto.TwitFindRequest;
import by.prokopovich.switter.twit.web.dto.TwitRequestDto;
import by.prokopovich.switter.twit.web.dto.TwitResponseDto;
import by.prokopovich.switter.user.profile.api.CurrentUserProfileApiService;
import by.prokopovich.switter.user.profile.model.UserProfile;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;

import static by.prokopovich.switter.twit.model.Twit_.CREATED_AT;

@Service
@RequiredArgsConstructor
public class TwitServiceImpl implements TwitService {
    private final TwitRequestDtoToTwitImpl mapperToTwit;
    private final TwitRepository twitRepository;
    private final TwitToTwitResponseDtoMapper mapperToDtoResponse;
    private final TwitEditRequestToTwitMapper editRequestToTwitMapper;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public Twit findTwitById(Long id) {
        return twitRepository.findById(id).orElseThrow(() -> new RuntimeException("Твит не найден"));
    }

    @Override
    public TwitResponseDto createTwit(TwitRequestDto dto) {
        Twit twit = mapperToTwit.map(dto);
        Twit saved = twitRepository.save(twit);
        return mapperToDtoResponse.map(saved);
    }

    @Transactional
    @Modifying
    @Override
    public TwitResponseDto editTwit(TwitEditRequest editRequest) {
        UserProfile actor = currentUserProfileApiService.currentUserProfile();
        UserProfile owner = twitRepository.findById(editRequest.getId()).map(Twit::getUserProfile).orElseThrow(() -> {
            String errorMessage = String.format("Твит с id =%d не существует", editRequest.getId());
            return new RuntimeException(errorMessage);
        });
        if (!actor.equals(owner)) {
            String errorMessage = String.format("Редактирование твита с id = %d запрещено. " +
                    "Пользователь %s не является его владельцем", editRequest.getId(), actor.getNickname());
            throw new RuntimeException(errorMessage);
        }
        Twit updated = editRequestToTwitMapper.map(editRequest);
        System.out.println(updated);
        twitRepository.updateMessageById(updated.getMessage(), updated.getId());
        return mapperToDtoResponse.map(updated);
    }

    @Override
    public void deleteTwit(Long id) {
        UserProfile actor = currentUserProfileApiService.currentUserProfile();
        UserProfile owner = twitRepository.findById(id).map(Twit::getUserProfile).orElseThrow(() -> {
            String errorMessage = String.format("Твит с id =%d не существует", id);
            return new RuntimeException(errorMessage);
        });
        if (!actor.equals(owner)) {
            String errorMessage = String.format("Удаление твита с id = %d запрещено. " +
                    "Пользователь %s не является его владельцем", id, actor.getNickname());
            throw new RuntimeException(errorMessage);
        }
        twitRepository.deleteById(id);
    }

    @Override
    public Collection<TwitResponseDto> findTwits(TwitFindRequest findRequest) {
        UserProfile owner = currentUserProfileApiService.currentUserProfile();
        Sort sort= Sort.by(Sort.Direction.DESC,CREATED_AT);
        Pageable pageable = PageRequest.of(findRequest.page(), findRequest.limit(),sort);
        Collection<Twit> twits = twitRepository.findAllByUserProfile(owner,pageable);
        return twits.stream().map(mapperToDtoResponse::map).toList();
    }

}
