package br.org.sesisenai.suggestions.services;

import br.org.sesisenai.suggestions.dtos.SuggestionRequest;
import br.org.sesisenai.suggestions.dtos.SuggestionResponse;

public interface SuggestionService {

    //CREATE
    public SuggestionResponse create (SuggestionRequest request);
}
