package com.spring.TestProject.service;


import com.spring.TestProject.DTO.FormDTO;
import com.spring.TestProject.base.CRUDService;
import com.spring.TestProject.model.Role;

import java.util.List;

public interface FormService extends CRUDService<FormDTO, Long> {
    List<FormDTO> findAll();
    List<FormDTO> findAllByUserRole(Role role);
    List<FormDTO> findAllBySource(Boolean bool);
}
