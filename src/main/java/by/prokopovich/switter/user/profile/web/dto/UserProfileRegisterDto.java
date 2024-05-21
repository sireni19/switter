package by.prokopovich.switter.user.profile.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@AllArgsConstructor
public class UserProfileRegisterDto {
    @NotBlank(message = "Не должен быть пустым")
    private String nickname;
    @NotBlank(message = "Не должен быть пустым")
    private String imageLink;
}
