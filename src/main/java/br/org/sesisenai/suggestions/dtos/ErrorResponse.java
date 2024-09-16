package br.org.sesisenai.suggestions.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Error response")
@Builder
public class ErrorResponse {

    @Schema(description = "Exception class", example = "exception")
    private String exceptionClass;

    @Schema(description = "Error message", example = "Internal server error")
    private String message;

    @Schema(description = "Error code", example = "500")
    private Integer code;

//    @Schema(description = "Error status", example = "INTERNAL_SERVER_ERROR")
//    private String status;
//
//    @Schema(description = "Error path", example = "/suggestions")
//    private String path;
//
//    @Schema(description = "Error timestamp", example = "2021-09-01 08:00:00")
//    private String timestamp;

    @Schema(
            description = "Fields",
            type = "array",
            example = "[\"Title is required\", \"Invalid priority value\"]")
    private List<String> fields;
}
