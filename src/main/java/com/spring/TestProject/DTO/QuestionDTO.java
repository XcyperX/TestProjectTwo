package com.spring.TestProject.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class QuestionDTO implements Serializable {
    @JsonProperty("question_id")
    private Long id;

    private Boolean some;

    private String text;

    @JsonProperty("answers_list")
    private List<AnswerDTO> answers;

    @JsonProperty("form_id")
    private Long formId;
}
