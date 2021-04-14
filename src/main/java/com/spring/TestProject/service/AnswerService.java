package com.spring.TestProject.service;


import com.spring.TestProject.DTO.AnswerDTO;
import com.spring.TestProject.base.CRUDService;

import java.util.List;

public interface AnswerService extends CRUDService<AnswerDTO, Long> {
    List<AnswerDTO> findAll();
}
