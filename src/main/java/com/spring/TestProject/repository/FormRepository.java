package com.spring.TestProject.repository;

import com.spring.TestProject.model.Form;
import com.spring.TestProject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormRepository extends JpaRepository<Form, Long> {
    List<Form> findAllByUserRole(Role role);
    List<Form> findAllBySource(Boolean bool);
    List<Form> findAllByUserId(Long id);
}
