package by.prokopovich.switter.user.profile.service.impl;

import by.prokopovich.switter.user.profile.maper.UserProfileRegisterDtoToUserProfileMapperImpl;
import by.prokopovich.switter.user.profile.model.UserProfile;
import by.prokopovich.switter.user.profile.repository.UserProfileRepository;
import by.prokopovich.switter.user.profile.service.UserProfileService;
import by.prokopovich.switter.user.profile.web.dto.UserProfileRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserProfileRegisterDtoToUserProfileMapperImpl mapper;

    @Override
    public void createUserProfile(UserProfileRegisterDto dto) {
        if (userProfileRepository.existsByNickname(dto.getNickname())) {
            throw new RuntimeException(String.format
                    ("Профиль пользователя с таким никнеймом %s уже существует: ", dto.getNickname()));
        }
        userProfileRepository.save(mapper.map(dto));
    }

    @Override
    public Optional<UserProfile> findUserProfileById(Long userProfileId) {
        return userProfileRepository.findById(userProfileId);
    }

}
