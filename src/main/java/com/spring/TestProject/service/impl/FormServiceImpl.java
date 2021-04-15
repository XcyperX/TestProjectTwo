package com.spring.TestProject.service.impl;

import com.spring.TestProject.DTO.FormDTO;
import com.spring.TestProject.DTO.UserDTO;
import com.spring.TestProject.model.Form;
import com.spring.TestProject.model.Role;
import com.spring.TestProject.model.User;
import com.spring.TestProject.repository.FormRepository;
import com.spring.TestProject.repository.UserRepository;
import com.spring.TestProject.service.FormService;
import com.spring.TestProject.service.UserService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FormServiceImpl implements FormService {
    private final FormRepository formRepository;
    private final MapperFacade mapperFacade;

    @Override
    public FormDTO getById(Long id) {
        if (formRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такой анкеты!");
        }
        return mapperFacade.map(formRepository.findById(id).get(), FormDTO.class);
    }

    @Override
    public FormDTO save(FormDTO formDTO) {
        if (formDTO != null) {
            Form form = formRepository.save(mapperFacade.map(formDTO, Form.class));
            return mapperFacade.map(form, FormDTO.class);
        }
        return null;
    }

    @Override
    @Transient
    public FormDTO update(FormDTO formDTO) {
        if (formRepository.findById(formDTO.getId()).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такой анкеты!");
        }
        Form form = formRepository.save(mapperFacade.map(formDTO, Form.class));
        return mapperFacade.map(form, FormDTO.class);
    }

    @Override
    public void delete(Long id) {
        if (formRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такой анкеты!");
        }
        formRepository.deleteById(id);
    }

    @Override
    public List<FormDTO> findAll() {
        return mapperFacade.mapAsList(formRepository.findAll(), FormDTO.class);
    }

    @Override
    public List<FormDTO> findAllByUserRole(Role role) {
        return mapperFacade.mapAsList(formRepository.findAllByUserRole(role), FormDTO.class);
    }

    @Override
    public List<FormDTO> findAllBySource(Boolean bool) {
        return mapperFacade.mapAsList(formRepository.findAllBySource(bool), FormDTO.class);
    }
}
