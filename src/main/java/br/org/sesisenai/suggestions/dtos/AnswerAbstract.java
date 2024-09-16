package br.org.sesisenai.suggestions.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Suggestion abstract")
public abstract class AnswerAbstract {

    @NotNull(message = "Answer is required")
    @Column(name = "answer", nullable = false)
    @Schema(description = "Answer", example = "Thanks for your feedback")
    private String answer;

}
