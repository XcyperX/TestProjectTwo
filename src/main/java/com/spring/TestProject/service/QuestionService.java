package com.spring.TestProject.service;


import com.spring.TestProject.DTO.QuestionDTO;
import com.spring.TestProject.base.CRUDService;

import java.util.List;

public interface QuestionService extends CRUDService<QuestionDTO, Long> {
    List<QuestionDTO> findAll();
}
