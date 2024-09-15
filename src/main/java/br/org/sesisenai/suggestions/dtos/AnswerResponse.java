package br.org.sesisenai.suggestions.dtos;

import br.org.sesisenai.suggestions.entities.Answer;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class AnswerResponse extends AnswerAbstract {

    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sendDate;

    public AnswerResponse(Answer answer) {
        BeanUtils.copyProperties(answer, this);
    }
}
