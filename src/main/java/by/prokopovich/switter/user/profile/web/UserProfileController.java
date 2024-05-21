package by.prokopovich.switter.user.profile.web;

import by.prokopovich.switter.user.profile.service.UserProfileService;
import by.prokopovich.switter.user.profile.web.dto.UserProfileRegisterDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-profiles")
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserProfile(@Valid @RequestBody UserProfileRegisterDto dto){
        userProfileService.createUserProfile(dto);
    }

}
