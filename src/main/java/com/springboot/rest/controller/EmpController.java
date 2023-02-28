package com.springboot.rest.controller;

import com.springboot.rest.dto.EmployeeDto;
import com.springboot.rest.service.inter.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    //====================================================================================================================
    //To add or insert the Employee
    @PostMapping("/emp")
    public String addEmployee(@RequestBody EmployeeDto employeeDto){
        return  empService.addEmployee(employeeDto);
    }
  //====================================================================================================================
    //To get Employee By Id

    @GetMapping("/emp/{idd}")
  public EmployeeDto getEmployeeById(@PathVariable("idd") int id) {
        return empService.getEmployeeById(id);
  }
    //====================================================================================================================
//to Get All the Employee
    @GetMapping("/emp")
    public List<EmployeeDto> getAllTheEmployee() {
        return empService.getAllTheEmployee();
    }
    //====================================================================================================================

    //to update the employee
    @PutMapping("/emp")
    public String updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return  empService.updateEmployee(employeeDto);
    }
    //====================================================================================================================
 //to delete the Employee
    @DeleteMapping("/emp/{emp_id}")
    public String deleteEmployee(@PathVariable("emp_id") int id) {
        return empService.deleteEmployee(id);
    }
    //====================================================================================================================
    //To calculate Final Salary of a month for a Emp Depending of  no of days he worked
    @GetMapping("/emp/tsal/{id}")
    public String calEmpGrossSalary(@PathVariable("id") int id) {
        return  "Employee Salary for This month is:"+empService.calEmpGrossSalary(id);
    }
    //====================================================================================================================
    //To Get Basic information of a particular Employee
    @GetMapping("/emp/basic/{id}")
    public String getBasicInformation(@PathVariable int id) {
        return empService.getBasicInformation(id);
    }
//====================================================================================================================
    //To get All Details of the Employee with id and password
@GetMapping("/emp/all/{id}/{pwd}")
    public String getAllEmpInformation(@PathVariable("id") int id, @PathVariable("pwd") String password) {
        return empService.getAllEmpInformation(id,password);
    }
    //==================================================================================================================
    //To get the salary based on the Working Days
    @GetMapping("/emp/month/{id}")
    public String monthlySalBasedOnAttendance(@PathVariable int id) {
        return  empService.monthlySalBasedOnAttendance(id);
    }
    //==================================================================================================================
}
