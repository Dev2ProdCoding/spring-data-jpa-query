package com.dev2prod.springdatajpaquery.controller;

import com.dev2prod.springdatajpaquery.entity.Employee;
import com.dev2prod.springdatajpaquery.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployeeData();
    }

    @GetMapping("/findEmployeesByDesignationAndActiveData/{activeState}/{designationList}")
    public List<Employee> findEmployeesByDesignationAndActiveData(@PathVariable Boolean activeState,
                                                                      @PathVariable List<String> designationList){
        return  employeeService.findEmployeesByDesignationAndActiveData(activeState,designationList);
    }

    @PutMapping("/updateEmployeeState/{activeState}/{empIdList}")
    public int updateEmployeeState(@PathVariable Boolean activeState,
                                   @PathVariable List<Long> empIdList) {
        return employeeService.updateEmployeeState(activeState, empIdList);
    }
}
