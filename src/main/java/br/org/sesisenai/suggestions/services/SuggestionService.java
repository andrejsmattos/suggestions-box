package br.org.sesisenai.suggestions.services;

import br.org.sesisenai.suggestions.dtos.SuggestionRequest;
import br.org.sesisenai.suggestions.dtos.SuggestionResponse;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public interface SuggestionService {

    //READ
    public Page<SuggestionResponse> findAll(String title, int pageNo, int pageSize);

    //CREATE
    public SuggestionResponse create (SuggestionRequest request);
}
