package br.org.sesisenai.suggestions.services;

import br.org.sesisenai.suggestions.dtos.SuggestionRequest;
import br.org.sesisenai.suggestions.dtos.SuggestionResponse;
import br.org.sesisenai.suggestions.entities.Suggestion;
import br.org.sesisenai.suggestions.repositories.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository repository;

    @Override
    public SuggestionResponse create(SuggestionRequest request) {
        log.info("Creating suggestion: {}", request.getTitle());
        Suggestion suggestion = new Suggestion();
        BeanUtils.copyProperties(request, suggestion);
        suggestion.setSendDate(LocalDateTime.now());

        SuggestionResponse response = save(suggestion);
        log.info("Created suggestion: {}", suggestion.getTitle());
        return response;
    }

    private SuggestionResponse save(Suggestion suggestion) {
        log.info("Saving suggestion: {}", suggestion.getTitle());
        repository.save(suggestion);

        log.info("Saved suggestion: {}", suggestion.getTitle());
        return new SuggestionResponse(suggestion);
    }
}
