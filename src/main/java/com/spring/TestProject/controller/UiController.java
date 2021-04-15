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
//
//    @GetMapping("/users")
//    public String listUsers(Model model) throws TemplateModelException {
//        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
//        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.model.Role");
//        model.addAttribute("roles", myRoles);
//        model.addAttribute("users", userService.findAll());
//        return "usersList";
//    }
//
//    @GetMapping("/users/edit/{id}")
//    public String listUsers(@PathVariable("id") Long id, Model model) throws TemplateModelException {
//        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
//        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.model.Role");
//        model.addAttribute("roles", myRoles);
//        model.addAttribute("user", userService.getById(id));
//        return "editUser";
//    }
//
//    @GetMapping("/employees")
//    public String listEmployees(Model model) throws TemplateModelException {
//        TemplateHashModel gender = BeansWrapper.getDefaultInstance().getEnumModels();
//        gender = (TemplateHashModel) gender.get("com.spring.model.Gender");
//        model.addAttribute("employees", employeeService.findAll());
//        model.addAttribute("subdivisions", subdivisionService.findAll());
//        model.addAttribute("genders", gender);
//        model.addAttribute("positions", positionService.findAll());
//        model.addAttribute("positionsNames", positionNameService.findAll());
//        return "listEmployeesByAll";
//    }
//
//    @GetMapping("/employees/agreement")
//    public String listEmployeesByAgreement(Model model) throws TemplateModelException {
//        TemplateHashModel gender = BeansWrapper.getDefaultInstance().getEnumModels();
//        gender = (TemplateHashModel) gender.get("com.spring.model.Gender");
//        TemplateHashModel payments = BeansWrapper.getDefaultInstance().getEnumModels();
//        payments = (TemplateHashModel) payments.get("com.spring.model.Payment");
//        model.addAttribute("employees", employeeService.findAll());
//        model.addAttribute("subdivisions", subdivisionService.findAll());
//        model.addAttribute("genders", gender);
//        model.addAttribute("positions", positionService.findAll());
//        model.addAttribute("positionsNames", positionNameService.findAll());
//        model.addAttribute("agreementData", agreementDataService.findAll());
//        model.addAttribute("payments", payments);
//        return "listEmployeesByAgreement";
//    }
//
//    @GetMapping("/vacation")
//    public String listEmployeesByVacation(Model model) {
//        model.addAttribute("employees", employeeService.findAll());
//        model.addAttribute("subdivisions", subdivisionService.findAll());
//        model.addAttribute("positions", positionService.findAll());
//        model.addAttribute("positionsNames", positionNameService.findAll());
//        return "listEmployeesByVacation";
//    }
//
//    @GetMapping(value = "/pdf/request", produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> chequeRequestReport(@AuthenticationPrincipal User user){
//        PDFGenerator pdfGenerator = new PDFGenerator();
//        ByteArrayInputStream bis = pdfGenerator.PDFReport(employeeService.findAll(), user, positionNameService.findAll(), subdivisionService.findAll());
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=Отчет.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }
//
//    @GetMapping(value = "/pdf/request/agreement", produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> profitReport(@AuthenticationPrincipal User user){
//        PDFGenerator pdfGenerator = new PDFGenerator();
//        ByteArrayInputStream bis = pdfGenerator.PDFReportAgreement(employeeService.findAll(), user, agreementDataService.findAll(), subdivisionService.findAll());
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "inline; filename=Договор подряда.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }
}
