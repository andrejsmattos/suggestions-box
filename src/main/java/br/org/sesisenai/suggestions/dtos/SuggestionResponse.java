package br.org.sesisenai.suggestions.dtos;

import br.org.sesisenai.suggestions.entities.Suggestion;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SuggestionResponse extends SuggestionAbstract{

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sendDate;

    public SuggestionResponse(Suggestion suggestion) {
        BeanUtils.copyProperties(suggestion, this);
    }

    public static List<SuggestionResponse> from(Page<Suggestion> suggestions) {
        return suggestions.map(SuggestionResponse::new).getContent();
    }
}
