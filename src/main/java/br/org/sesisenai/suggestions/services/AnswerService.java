package br.org.sesisenai.suggestions.services;

import br.org.sesisenai.suggestions.dtos.AnswerRequest;
import br.org.sesisenai.suggestions.dtos.AnswerResponse;

public interface AnswerService {

    //CREATE
    AnswerResponse create (Long id, AnswerRequest request);
}
