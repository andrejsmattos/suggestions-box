package br.org.sesisenai.suggestions.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Suggestion abstract")
public abstract class SuggestionAbstract {

    @Schema(description = "Suggestion title", example = "Great professionals!")
    private String title;

    @Schema(description = "Suggestion description", example = "The professionals are very qualified and kind!")
    private String description;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime sendDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "Date and time suggestion was updated", example = "2021-09-01 12:00:00")
    private LocalDateTime updateDate;

}
