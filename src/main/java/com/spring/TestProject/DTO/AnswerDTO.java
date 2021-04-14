package com.spring.TestProject.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class AnswerDTO {
    @JsonProperty("answer_id")
    private Long id;

    private Boolean choice;

    private String text;

    @JsonProperty("questions_id")
    private Long questionId;
}
