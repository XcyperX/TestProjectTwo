package com.spring.TestProject.repository;

import com.spring.TestProject.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
}
