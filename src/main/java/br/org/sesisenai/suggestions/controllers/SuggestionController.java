package br.org.sesisenai.suggestions.controllers;

import br.org.sesisenai.suggestions.dtos.SuggestionRequest;
import br.org.sesisenai.suggestions.dtos.SuggestionResponse;
import br.org.sesisenai.suggestions.services.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    @Autowired
    private SuggestionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuggestionResponse post (@RequestBody SuggestionRequest request) {
        return service.create(request);
    }
}
