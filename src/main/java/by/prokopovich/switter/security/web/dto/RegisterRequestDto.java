package by.prokopovich.switter.security.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class RegisterRequestDto {
    @NotNull(message = "email не должен быть null")
    @NotBlank(message = "email не должен быть пустым")
    @Email(message = "некорректный email")
    private String username;
    @NotBlank(message = "password не должен быть пустым")
    private String password;
}
