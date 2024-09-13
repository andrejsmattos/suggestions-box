package br.org.sesisenai.suggestions.dtos;

import br.org.sesisenai.suggestions.entities.Suggestion;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SuggestionResponse extends SuggestionAbstract{

    private Long id;

    public SuggestionResponse(Suggestion suggestion) {
        BeanUtils.copyProperties(suggestion, this);
    }
}
