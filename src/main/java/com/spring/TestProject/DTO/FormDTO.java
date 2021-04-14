package com.spring.TestProject.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
public class FormDTO {
    @JsonProperty("form_id")
    private Long id;

    @JsonProperty("name_form")
    private String nameForm;

    @JsonProperty("questions_list")
    private List<QuestionDTO> questionDTOList;

    @JsonProperty("user_id")
    private Long userId;
}
