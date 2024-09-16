package br.org.sesisenai.suggestions.dtos;

import br.org.sesisenai.suggestions.entities.Suggestion;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Suggestion response")
public class SuggestionResponse extends SuggestionAbstract{

    @Schema(description = "Id", example = "1")
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "Date and time suggestion  was sent", example = "2021-09-01 08:00:00")
    private LocalDateTime sendDate;

//    @Schema(description = "List of answers")
//    private List<AnswerResponse> answers;

    public SuggestionResponse(Suggestion suggestion) {
        BeanUtils.copyProperties(suggestion, this);
    }

    public static List<SuggestionResponse> from(Page<Suggestion> suggestions) {
        return suggestions.map(SuggestionResponse::new).getContent();
    }
}
