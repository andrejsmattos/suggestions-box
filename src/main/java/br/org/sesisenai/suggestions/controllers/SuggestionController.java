package br.org.sesisenai.suggestions.controllers;

import br.org.sesisenai.suggestions.dtos.SuggestionRequest;
import br.org.sesisenai.suggestions.dtos.SuggestionResponse;
import br.org.sesisenai.suggestions.services.SuggestionServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionServiceImpl service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<SuggestionResponse> get (
        @RequestParam(required = false) String title,
        Pageable pageable) {
            log.info("GET /suggestions -> Begin");
            Page<SuggestionResponse> response = service.findAll(title, pageable.getPageNumber(), pageable.getPageSize());
            log.info("GET /suggestions -> End");
            return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuggestionResponse post (@RequestBody SuggestionRequest request) {
        log.info("POST /suggestions -> Begin");
        SuggestionResponse response = service.create(request);
        log.info("POST /suggestions -> End");
        return response;
    }
}
