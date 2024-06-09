package by.prokopovich.switter.twit.web;

import by.prokopovich.switter.twit.model.Twit;
import by.prokopovich.switter.twit.repository.TwitRepository;
import by.prokopovich.switter.twit.service.TwitService;
import by.prokopovich.switter.twit.web.dto.TwitEditRequest;
import by.prokopovich.switter.twit.web.dto.TwitRequestDto;
import by.prokopovich.switter.twit.web.dto.TwitResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/twits")
@RequiredArgsConstructor
public class TwitController {
    private final TwitService twitService;
    private final TwitRepository twitRepository;
    @GetMapping("/{id}")
    public Twit getTwit(@PathVariable Long id) {
        System.out.println(twitRepository.findById(id).get());
        return twitRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public TwitResponseDto addTwit(@RequestBody @Valid TwitRequestDto dto) {
        return twitService.createTwit(dto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public TwitResponseDto editTwit(@RequestBody @Valid TwitEditRequest editRequest) {
        System.out.println(editRequest);
        return twitService.editTwit(editRequest);
    }
}


