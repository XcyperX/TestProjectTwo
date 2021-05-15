package com.spring.TestProject.controller;

import com.spring.TestProject.model.User;
import com.spring.TestProject.report.PDFGenerator;
import com.spring.TestProject.service.FormService;
import com.spring.TestProject.service.UserService;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UiController {
    private final UserService userService;
    private final FormService formService;

    @GetMapping("/login")
    public String registration(Model model) throws TemplateModelException {
        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.TestProject.model.Role");
        model.addAttribute("roles", myRoles);
        return "login";
    }

    @GetMapping("/forms")
    public String listForms(Model model) {
        model.addAttribute("forms", formService.findAllBySource(true));
        return "listForm";
    }

    @GetMapping("/forms/{id}")
    public String listForms(@AuthenticationPrincipal User user, Model model, @PathVariable("id") Long id) {
        model.addAttribute("form", formService.getById(id));
        model.addAttribute("user", user);
        return "formPage";
    }

    @GetMapping("/admin/forms")
    public String createForm(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "createForm";
    }

    @GetMapping("/admin/passed/forms")
    public String listPassedForm(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("forms", formService.findAllBySource(false));
        return "listPassedForms";
    }

    @GetMapping("/admin/users")
    public String listUsers(Model model) throws TemplateModelException {
        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.TestProject.model.Role");
        model.addAttribute("roles", myRoles);
        model.addAttribute("forms", formService.findAllBySource(true));
        model.addAttribute("users", userService.findAll());
        return "listUsers";
    }

    @GetMapping("/users/forms")
    public String listFormsUsers(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("forms", formService.findAllByUserId(user.getId()));
        return "listFormsUser";
    }

    @GetMapping(value = "admin/api/pdf/users", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> usersReport(@AuthenticationPrincipal User user) throws IOException {
        ByteArrayInputStream bis = PDFGenerator.usersReport(userService.findAll(), user);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Отчет по пользователям.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping(value = "api/pdf/passed/forms", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> passedFormsReport(@AuthenticationPrincipal User user) throws IOException {
        ByteArrayInputStream bis = PDFGenerator.passedFormsReport(formService.findAllBySource(false), user);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Отчет по пройденным анкетам.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
