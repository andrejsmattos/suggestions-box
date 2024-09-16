package br.org.sesisenai.suggestions.controllers;

import br.org.sesisenai.suggestions.dtos.AnswerRequest;
import br.org.sesisenai.suggestions.dtos.AnswerResponse;
import br.org.sesisenai.suggestions.services.AnswerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
@Tag(name = "Answers", description = "Create an answer for a suggestion")
public class AnswerController {

    private final AnswerServiceImpl service;

    @PostMapping("suggestions/{id}/answers")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Create answers for a specific suggestion", summary = "Create answer")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Success") })
    public AnswerResponse post (
        @Parameter(description = "Suggestion id")
        @PathVariable Long id,
        @RequestBody AnswerRequest request) {
            log.info("POST /suggestions/{}/answers -> Begin", id);
            AnswerResponse response = service.create(id, request);
            log.info("POST /suggestions/{}/answers -> End", id);
            return response;
    }

}
