//package com.codegym.controller;
//
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class EmployeeController {
//    @Autowired
//    private IEmployeeService employeeService;
//
//    @Autowired
//    private IDivisionService divisionService;
//
//    @Autowired
//    private IEducationDegreeService educationDegreeService;
//
//    @Autowired
//    private IPositionService positionService;
//
//    @GetMapping("/list")
//    public String showList(@PageableDefault(value = 5) Pageable pageable,
//                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
//                           @RequestParam(value = "addressSearch", defaultValue = "") String addressSearch,
//                           @RequestParam(value = "phoneSearch", defaultValue = "") String phoneSearch, Model model) {
//        List<Position> positionList = positionService.findAll();
//        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
//        List<Division> divisionList = divisionService.findAll();
//        Page<Employee> employeeList = employeeService.searchEmployee(nameSearch, addressSearch, phoneSearch, pageable);
//        model.addAttribute("nameSearch", nameSearch);
//        model.addAttribute("addressSearch", addressSearch);
//        model.addAttribute("phoneSearch", phoneSearch);
//        model.addAttribute("positionList", positionList);
//        model.addAttribute("educationDegreeList", educationDegreeList);
//        model.addAttribute("divisionList", divisionList);
//        model.addAttribute("employeeList", employeeList);
//        model.addAttribute("employeeDto", new EmployeeDto());
//        return "employee/list";
//    }
//
//    @PostMapping("/save")
//    public String save(@ModelAttribute @Validated EmployeeDto employeeDto,
//                       RedirectAttributes redirectAttributes, Model model) {
//
//        model.addAttribute("positionList", positionService.findAll());
//        model.addAttribute("divisionList", divisionService.findAll());
//        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
//        Employee employee = new Employee();
//        BeanUtils.copyProperties(employeeDto, employee);
//        employeeService.save(employee);
//        redirectAttributes.addFlashAttribute("mess", employee.getEmployeeName() +
//                " thêm mới thành công");
//        return "redirect:/employee/list";
//    }
//
//    @GetMapping("/delete")
//    public String delete(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
//        employeeService.deleteLogical(id);
//        redirectAttributes.addFlashAttribute("mess", "xóa khách hàng" +
//                employeeService.findById(id).get().getEmployeeName() + " thành công");
//        return "redirect:/employee/list";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String showFormEdit(@PathVariable Integer id, Model model) {
//        model.addAttribute("positionList", positionService.findAll());
//        model.addAttribute("divisionList", divisionService.findAll());
//        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
//        model.addAttribute("employeeDto", employeeService.findById(id).get());
//        return "employee/edit";
//    }
//
//    @PostMapping("/update")
//    public String updateCustomer(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult,
//                                 RedirectAttributes redirectAttributes,Model model ) {
//        if(bindingResult.hasFieldErrors()){
//            model.addAttribute("positionList", positionService.findAll());
//            model.addAttribute("divisionList", divisionService.findAll());
//            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
//            return "employee/edit";
//        }
//        Employee employee = new Employee();
//        BeanUtils.copyProperties(employeeDto, employee);
//        employeeService.update(employee);
//        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa khách hàng thành công!");
//        return "redirect:/employee/list";
//
//    }
//}
