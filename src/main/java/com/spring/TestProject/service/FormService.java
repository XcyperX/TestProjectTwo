package com.spring.TestProject.service;


import com.spring.TestProject.DTO.FormDTO;
import com.spring.TestProject.base.CRUDService;

import java.util.List;

public interface FormService extends CRUDService<FormDTO, Long> {
    List<FormDTO> findAll();
}
