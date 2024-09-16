package br.org.sesisenai.suggestions.dtos;

import br.org.sesisenai.suggestions.entities.Answer;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Answer response")
public class AnswerResponse extends AnswerAbstract {

    @NotNull(message = "Suggestion id is required")
    @Column(name = "suggestion_id", nullable = false)
    @Schema(description = "Suggestion id", example = "1")
    private Long idSuggestion;

    @Schema(description = "Id", example = "1")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "Date and time answer was sent", example = "2021-09-01 10:00:00")
    private LocalDateTime sendDate;

    public AnswerResponse(Answer answer) {
        BeanUtils.copyProperties(answer, this);
    }
}
