package br.org.sesisenai.suggestions.services;

import br.org.sesisenai.suggestions.dtos.SuggestionRequest;
import br.org.sesisenai.suggestions.dtos.SuggestionResponse;
import br.org.sesisenai.suggestions.entities.Suggestion;
import br.org.sesisenai.suggestions.repositories.SuggestionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SuggestionService {

    @Autowired
    private SuggestionRepository repository;


    public SuggestionResponse create(SuggestionRequest request) {
        Suggestion suggestion = new Suggestion();
        BeanUtils.copyProperties(request, suggestion);
        suggestion.setSendDate(LocalDateTime.now());

        Suggestion savedSuggestion = repository.save(suggestion);

        SuggestionResponse response = new SuggestionResponse();
        BeanUtils.copyProperties(savedSuggestion, response);

        return response;
    }
}
