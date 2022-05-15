package com.example.employeewiththymeleaf.controller;

import com.example.employeewiththymeleaf.repository.EmployeeRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    @GetMapping({"/list", "/"})
    public  ModelAndView getAllEmployees(){
        ModelAndView mav = new ModelAndView("list_employees");
        mav.addObject("employees",employeeRepository.findAll());
        return mav;
    }

}
