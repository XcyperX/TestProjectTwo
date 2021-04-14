package com.spring.TestProject.controller;

import com.spring.TestProject.DTO.FormDTO;
import com.spring.TestProject.DTO.UserDTO;
import com.spring.TestProject.service.FormService;
import com.spring.TestProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestApiController {
    private final UserService userService;
    private final FormService formService;

    @PostMapping("/registrations")
    public UserDTO registrationUser(@RequestBody @Valid UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PutMapping("/users/{id}")
    public UserDTO updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        return userService.update(userDTO);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/forms")
    public FormDTO createForm(@RequestBody @Valid FormDTO formDTO) {
        return formService.save(formDTO);
    }

    @PutMapping("/forms/{id}")
    public FormDTO updateForm(@PathVariable("id") Long id, @RequestBody FormDTO formDTO) {
        formDTO.setId(id);
        return formService.update(formDTO);
    }

    @DeleteMapping("/forms/{id}")
    public void deleteForm(@PathVariable("id") Long id) {
        formService.delete(id);
    }

    @GetMapping("/forms")
    public ResponseEntity<?> getForm() {
        return ResponseEntity.ok(formService.findAll());
    }
}
