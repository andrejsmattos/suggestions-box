package br.org.sesisenai.suggestions.controllers;

import br.org.sesisenai.suggestions.dtos.SuggestionRequest;
import br.org.sesisenai.suggestions.dtos.SuggestionResponse;
import br.org.sesisenai.suggestions.services.SuggestionServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuggestionResponse post (@RequestBody SuggestionRequest request) {
        log.info("POST /suggestions -> Begin");
        SuggestionResponse response = service.create(request);
        log.info("POST /suggestions -> End");
        return response;
    }
}
