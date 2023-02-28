package com.springboot.rest.service.inter;

import com.springboot.rest.dto.EmployeeDto;

import java.util.List;

public interface EmpService {
//=============================================================================
    //To add or insert the Employee
    public String addEmployee(EmployeeDto employeeDto);
    //=============================================================================
    //To get Employee By ID
    public EmployeeDto getEmployeeById(int id);
    //=============================================================================
    //To get All The Employee
    public List<EmployeeDto> getAllTheEmployee();
    //=============================================================================
    //To Update the Employee
    public String updateEmployee(EmployeeDto employeeDto);
    //=============================================================================
    //To Delete the Employee
    public String deleteEmployee(int id);
    //=============================================================================
    //To calculate Final Salary of a month for a Emp Depending of  no of days he worked
    public String calEmpGrossSalary(int id);
//=============================================================================
    //To Get Basic information of a particular Employee
    public String getBasicInformation(int id);
    //=============================================================================
    //To get All Details of the Employee with id and password
    public String  getAllEmpInformation(int id,String password);
    //=============================================================================
    //To get the salary based on the attendance
   public String monthlySalBasedOnAttendance(int id);
//=============================================================================







}
