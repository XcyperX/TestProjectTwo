package com.spring.TestProject.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UiController {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private EmployeeService employeeService;
//    @Autowired
//    private AddressService addressService;
//    @Autowired
//    private PositionService positionService;
//    @Autowired
//    private SubdivisionService subdivisionService;
//    @Autowired
//    private AgreementDataService agreementDataService;
//    @Autowired
//    private PositionNameService positionNameService;
//
//
//    @GetMapping("/registration")
//    public String registration(Model model) throws TemplateModelException {
//        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
//        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.spring.model.Role");
//        model.addAttribute("roles", myRoles);
//        return "registration";
//    }
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
