package br.org.sesisenai.suggestions.controllers;

import br.org.sesisenai.suggestions.dtos.AnswerRequest;
import br.org.sesisenai.suggestions.dtos.AnswerResponse;
import br.org.sesisenai.suggestions.services.AnswerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class AnswerController {

    private final AnswerServiceImpl service;

    @PostMapping("suggestions/{id}/answers")
    @ResponseStatus(HttpStatus.CREATED)
    public AnswerResponse post (
        @PathVariable Long id,
        @RequestBody AnswerRequest request) {
            log.info("POST /suggestions/{}/answers -> Begin", id);
            AnswerResponse response = service.create(id, request);
            log.info("POST /suggestions/{}/answers -> End", id);
            return response;
    }

}
