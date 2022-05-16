package com.example.employeewiththymeleaf.controller;

import com.example.employeewiththymeleaf.domain.Employee;
import com.example.employeewiththymeleaf.repository.EmployeeRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Data
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping({"/list", "/","/showEmployees"})
    public  ModelAndView getAllEmployees(){
        ModelAndView mav = new ModelAndView("list_employees");
        mav.addObject("employees",employeeRepository.findAll());
        return mav;
    }

    @GetMapping({"addEmployeeForm"})
    public  ModelAndView addEmployee(){
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee newEmployee = new Employee();
        mav.addObject("employee",newEmployee);
        return mav;
    }
    @PostMapping("/saveEmployee")  // bind employee to employee object
    public String SaveEmployee(@ModelAttribute Employee employee){
        employeeRepository.save(employee);
        return "redirect:/list";
    }
    @GetMapping("/deleteEmployee")
    public String DeleteEmployee(@RequestParam Long employeeId){
        employeeRepository.deleteById(employeeId);
        return "redirect:/list";
    }
    @GetMapping("showUpdateForm")
    //  @RequestParam used to bind to employee
    public ModelAndView showUpdateForm(@RequestParam Long employeeId){
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee employee = employeeRepository.findById(employeeId).get();
        mav.addObject("employee",employee);
        return mav;
    }

}
