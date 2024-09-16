package br.org.sesisenai.suggestions.controllers;

import br.org.sesisenai.suggestions.dtos.SuggestionRequest;
import br.org.sesisenai.suggestions.dtos.SuggestionResponse;
import br.org.sesisenai.suggestions.services.SuggestionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/suggestions")
@Tag(name = "Suggestions", description = "Create and list suggestions")
public class SuggestionController {

    private final SuggestionServiceImpl service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "List all suggestions sorted by most recent updateDate", summary = "List suggestions")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success") })
    public Page<SuggestionResponse> get (
        @RequestParam(required = false) String title,
        @PageableDefault(size = 5, page = 0, sort = "updateDate", direction = Sort.Direction.ASC) Pageable pageable) {
            log.info("GET /suggestions -> Begin");
            Page<SuggestionResponse> response = service.findAll(title, pageable.getPageNumber(), pageable.getPageSize());
            log.info("GET /suggestions -> End");
            return response;
    }

    @Operation(description = "Find a suggestion by id", summary = "Find suggestion")
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success") })
    public SuggestionResponse getById(@PathVariable Long id) {
        log.info("GET /suggestions/{} -> Begin", id);
        SuggestionResponse response = service.findById(id);
        log.info("GET /suggestions/{} -> End", id);
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Create a suggestion", summary = "Create suggestion")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Success") })
    public SuggestionResponse post (@RequestBody SuggestionRequest request) {
        log.info("POST /suggestions -> Begin");
        SuggestionResponse response = service.create(request);
        log.info("POST /suggestions -> End");
        return response;
    }
}
