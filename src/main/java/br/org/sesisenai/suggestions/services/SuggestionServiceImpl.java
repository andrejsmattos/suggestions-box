package br.org.sesisenai.suggestions.services;

import br.org.sesisenai.suggestions.dtos.AnswerResponse;
import br.org.sesisenai.suggestions.dtos.SuggestionRequest;
import br.org.sesisenai.suggestions.dtos.SuggestionResponse;
import br.org.sesisenai.suggestions.entities.Suggestion;
import br.org.sesisenai.suggestions.exceptions.notfound.SuggestionNotFound;
import br.org.sesisenai.suggestions.repositories.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository repository;

    @Override
    public Page<SuggestionResponse> findAll(String title, int pageNo, int pageSize) {
        log.info("Finding all suggestions");

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("updateDate").descending());
        Page<Suggestion> suggestions;
        if (title != null && !title.isEmpty()) {
            suggestions = repository.findAllByTitleContainingIgnoreCase(title, pageable);
        } else {
            suggestions = repository.findAll(pageable);
        }
        repository.findAll(pageable);
        log.info("Found {} suggestions", suggestions.getNumberOfElements());

        return suggestions.map(SuggestionResponse::new);
    }

    @Override
    public SuggestionResponse findById(Long id) {
        log.info("Finding suggestion by id: {}", id);
        Suggestion suggestion = repository.findById(id)
                .orElseThrow(() -> new SuggestionNotFound(id));
//        List<AnswerResponse> answers = suggestion.getAnswer().stream()
//                .map(AnswerResponse::new)
//                .toList();
        log.info("Found suggestion by id: {}", id);
        return new SuggestionResponse(suggestion);
    }


    @Override
    public SuggestionResponse create(SuggestionRequest request) {
        log.info("Creating suggestion: {}", request.getTitle());
        Suggestion suggestion = new Suggestion();
        BeanUtils.copyProperties(request, suggestion);
        suggestion.setSendDate(LocalDateTime.now());
        suggestion.setUpdateDate(LocalDateTime.now());

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
