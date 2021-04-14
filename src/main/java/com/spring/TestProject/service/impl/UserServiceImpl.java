package com.spring.TestProject.service.impl;

import com.spring.TestProject.DTO.UserDTO;
import com.spring.TestProject.model.User;
import com.spring.TestProject.repository.UserRepository;
import com.spring.TestProject.service.UserService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MapperFacade mapperFacade;

    @Override
    public UserDTO getById(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого пользователя!");
        }
        return mapperFacade.map(userRepository.findById(id).get(), UserDTO.class);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        if (userDTO != null) {
            User user = userRepository.save(mapperFacade.map(userDTO, User.class));
            return mapperFacade.map(user, UserDTO.class);
        }
        return null;
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        if (userRepository.findById(userDTO.getId()).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого пользователя!");
        }
        User user = userRepository.save(mapperFacade.map(userDTO, User.class));
        return mapperFacade.map(user, UserDTO.class);
    }

    @Override
    public void delete(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого пользователя!");
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> findAll() {
        return mapperFacade.mapAsList(userRepository.findAll(), UserDTO.class);
    }
}
