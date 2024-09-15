package br.org.sesisenai.suggestions.services;

import br.org.sesisenai.suggestions.dtos.SuggestionRequest;
import br.org.sesisenai.suggestions.dtos.SuggestionResponse;
import org.springframework.data.domain.Page;

public interface SuggestionService {

    //READ
    Page<SuggestionResponse> findAll(String title, int pageNo, int pageSize);
    SuggestionResponse findById(Long id);

    //CREATE
    SuggestionResponse create (SuggestionRequest request);

}
