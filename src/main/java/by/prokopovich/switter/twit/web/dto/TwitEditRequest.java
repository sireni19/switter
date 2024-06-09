package by.prokopovich.switter.twit.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class TwitEditRequest {

    @NotNull
    private Long id;
    @NotBlank
    @Size(min = 1, max = 200)
    private String updatedMessage;
}
