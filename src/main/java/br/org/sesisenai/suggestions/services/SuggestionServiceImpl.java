package br.org.sesisenai.suggestions.services;

import br.org.sesisenai.suggestions.dtos.SuggestionRequest;
import br.org.sesisenai.suggestions.dtos.SuggestionResponse;
import br.org.sesisenai.suggestions.entities.Suggestion;
import br.org.sesisenai.suggestions.repositories.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository repository;

    @Override
    public SuggestionResponse create(SuggestionRequest request) {
        Suggestion suggestion = new Suggestion();
        BeanUtils.copyProperties(request, suggestion);
        suggestion.setSendDate(LocalDateTime.now());

        return save(suggestion);
    }

    private SuggestionResponse save(Suggestion suggestion) {
        repository.save(suggestion);
        return new SuggestionResponse(suggestion);
    }
}
