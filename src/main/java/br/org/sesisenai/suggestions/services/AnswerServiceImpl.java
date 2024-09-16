package br.org.sesisenai.suggestions.services;

import br.org.sesisenai.suggestions.dtos.AnswerRequest;
import br.org.sesisenai.suggestions.dtos.AnswerResponse;
import br.org.sesisenai.suggestions.entities.Answer;
import br.org.sesisenai.suggestions.entities.Suggestion;
import br.org.sesisenai.suggestions.exceptions.notfound.SuggestionNotFound;
import br.org.sesisenai.suggestions.repositories.AnswerRepository;
import br.org.sesisenai.suggestions.repositories.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService{

    private final AnswerRepository answerRepository;
    private final SuggestionRepository suggestionRepository;

    @Override
    public AnswerResponse create (Long id, AnswerRequest request) {
        log.info("Creating answer: {}", request.getAnswer());
        Suggestion suggestion = suggestionRepository.findById(id)
                .orElseThrow(() -> new SuggestionNotFound(id));
        suggestion.setUpdateDate(LocalDateTime.now());

        Answer answer = new Answer(request);
        answer.setSuggestion(suggestion);
        answer.getIdSuggestion();
        answer.setSendDate(LocalDateTime.now());

        AnswerResponse response = save(answer);
        log.info("Created answer: {}", request.getAnswer());
        return response;
    }

    private AnswerResponse save(Answer answer) {
        log.info("Saving answer with id: {}", answer.getId());
        answerRepository.save(answer);
        log.info("Answer saved with id: {}", answer.getId());
        return new AnswerResponse(answer);
    }
}
