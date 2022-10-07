package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;
import com.codegym.service.employee.IDivisionService;
import com.codegym.service.employee.IEducationDegreeService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "addressSearch", defaultValue = "") String addressSearch,
                           @RequestParam(value = "phoneSearch", defaultValue = "") String phoneSearch,
                           Model model) {
        Page<Employee> employeeList = iEmployeeService.searchEmployee(nameSearch, addressSearch, phoneSearch, pageable);
//        List<Position> positionList = iPositionService.findAll();
//        List<Division> divisionList = iDivisionService.findAll();
//        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("positionList", iEmployeeService.findAll());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("phoneSearch", phoneSearch);
        model.addAttribute("addressSearch", addressSearch);
        return "/employee/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        List<Position> positionList = iPositionService.findAll();
        List<Division> divisionList = iDivisionService.findAll();
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        List<Position> positionList = iPositionService.findAll();
        List<Division> divisionList = iDivisionService.findAll();
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("educationDegreeList", educationDegreeList);
            model.addAttribute("positionList", positionList);
            model.addAttribute("divisionList", divisionList);
            return "employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("success", "successfully added new !!");
            return "redirect:/employee/list";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("mess", "Update employee successfully!");
        return "redirect:/employee/list";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable int id, Model model) {
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        List<Position> positionList = iPositionService.findAll();
        List<Division> divisionList = iDivisionService.findAll();
        model.addAttribute("employee", iEmployeeService.findById(id));
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("divisionList", divisionList);
        return "/employee/edit";
    }

//    @GetMapping("/delete/{id}")
//    public String showDelete(@PathVariable int id, Model model) {
//        model.addAttribute("employee", iEmployeeService.findById(id));
//        return "employee/index";
//    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirect) {
        iEmployeeService.delete(id);
        redirect.addFlashAttribute("mess", "Removed customer successfully!");
        return "redirect:/employee/list";
    }

//    @GetMapping("/view")
//    public String viewEmployee(@RequestParam int id){
//        iEmployeeService.findById(id);
//        return "redirect:/employee/index";
//    }
}
