package com.spring.TestProject.controller;

import com.spring.TestProject.model.User;
import com.spring.TestProject.service.FormService;
import com.spring.TestProject.service.UserService;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}
