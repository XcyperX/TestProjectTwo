package com.spring.TestProject.service;

import com.spring.TestProject.DTO.UserDTO;
import com.spring.TestProject.base.CRUDService;

import java.util.List;

public interface UserService extends CRUDService<UserDTO, Long> {
    List<UserDTO> findAll();
}
