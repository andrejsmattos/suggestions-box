package br.org.sesisenai.suggestions.entities;

import br.org.sesisenai.suggestions.dtos.AnswerRequest;
import br.org.sesisenai.suggestions.dtos.SuggestionResponse;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "suggestion_id", nullable = false)
    private Suggestion suggestion;

    private String answer;
    private LocalDateTime sendDate;

    public Answer(AnswerRequest request) {
        BeanUtils.copyProperties(request, this);
    }

    public Long getIdSuggestion() {
        return suggestion.getId();
    }
}

