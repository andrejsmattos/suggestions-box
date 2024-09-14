package br.org.sesisenai.suggestions.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public abstract class AnswerAbstract {

    @NotNull(message = "O id da sugestão é obrigatório")
    @Column(name = "suggestion_id", nullable = false)
    private Long idSuggestion;

    @NotNull(message = "A resposta é obrigatória")
    private String answer;

}
