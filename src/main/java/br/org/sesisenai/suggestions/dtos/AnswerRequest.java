package br.org.sesisenai.suggestions.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Answer request")
public class AnswerRequest extends AnswerAbstract {

}
