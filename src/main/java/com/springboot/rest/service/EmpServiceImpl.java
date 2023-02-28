package com.springboot.rest.service;

import com.springboot.rest.dto.EmployeeDto;
import com.springboot.rest.entity.Attendance;
import com.springboot.rest.entity.Employee;
import com.springboot.rest.repositery.EmpRepositery;
import com.springboot.rest.service.inter.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

     @Autowired
   private EmpRepositery empRepositery;

     //========================================================================================================
    /*
     //To insert or Add the Employee
    @Override
    public String addEmployee(EmployeeDto employeeDto) {
        try {
            Employee emp=new Employee();

            emp.setEmpId(employeeDto.getEmpId());
            emp.setEmpName(employeeDto.getEmpName());
            emp.setEmpSalary(employeeDto.getEmpSalary());
            emp.setEmpDesg(employeeDto.getEmpDesg());
            emp.setEmpPassword(employeeDto.getEmpPassword());
            emp.setAttendance(employeeDto.getAttendance());

            emp=empRepositery.save(emp);

            if(emp!=null){
                return "Employee Added Successfully";
            }else{
                return "Employee Insertion Failed";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "Internal Server error...Fail to add the Employee";
        }

    }//end of Add emp

     */
//===========================================================================================================
     //To insert or Add the Employee

     @Override
     public String addEmployee(EmployeeDto employeeDto) {
         try {
             Employee emp=new Employee();

             emp.setEmpId(employeeDto.getEmpId());
             emp.setEmpName(employeeDto.getEmpName());
             emp.setEmpSalary(employeeDto.getEmpSalary());
             emp.setEmpDesg(employeeDto.getEmpDesg());
             emp.setEmpPassword(employeeDto.getEmpPassword());
             emp.setAttendance(employeeDto.getAttendance());

             emp.setMonthlySalar(monthlySalBasedOnAttendance(employeeDto.getEmpSalary(),employeeDto.getAttendance().getNoOfWorkingDays()));

             emp=empRepositery.save(emp);

             if(emp!=null){
                 return "Employee Added Successfully";
             }else{
                 return "Employee Insertion Failed";
             }

         }catch (Exception e){
             e.printStackTrace();
             return "Internal Server error...Fail to add the Employee";
         }

     }//end of Add emp

    //===========================================================================================================
    //getEmp by Id

    @Override
    public EmployeeDto getEmployeeById(int id) {
        EmployeeDto employeeDto =null;
         try{
             Optional<Employee>  optional = empRepositery.findById(id);
             if(optional.isPresent()){
                Employee  emp=optional.get();
                 employeeDto= new EmployeeDto();

                 employeeDto.setEmpId(emp.getEmpId());
                 employeeDto.setEmpName(emp.getEmpName());
                 employeeDto.setEmpSalary(emp.getEmpSalary());
                 employeeDto.setEmpDesg(emp.getEmpDesg());
                 employeeDto.setEmpPassword(emp.getEmpPassword());
                 employeeDto.setAttendance(emp.getAttendance());

                 employeeDto.setMonthlySalar(emp.getMonthlySalar());
             }

         }catch(Exception e){
             e.printStackTrace();
         }
        return employeeDto;
    }//end get emp by id

    //===========================================================================================================
    //Get all the Employee

    @Override
    public List<EmployeeDto> getAllTheEmployee() {
        List<EmployeeDto> dtoList=new ArrayList<>();
        try {
            List<Employee> allEmp = empRepositery.findAll();
            for(Employee e:allEmp){
                EmployeeDto dto=new EmployeeDto();
                dto.setEmpId(e.getEmpId());
                dto.setEmpName(e.getEmpName());
                dto.setEmpSalary(e.getEmpSalary());
                dto.setEmpDesg(e.getEmpDesg());
                dto.setEmpPassword(e.getEmpPassword());
                dto.setAttendance(e.getAttendance());
                dto.setMonthlySalar(e.getMonthlySalar());
                dtoList.add(dto);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return dtoList;
    }//end of get all the employee
    //===========================================================================================================
//To update the Employee

    @Override
    public String updateEmployee(EmployeeDto employeeDto) {
        try {
            Optional<Employee> option = empRepositery.findById(employeeDto.getEmpId());
            if(option.isPresent()){
                Employee emp=option.get();
                emp.setEmpId(employeeDto.getEmpId());
                emp.setEmpName(employeeDto.getEmpName());
                emp.setEmpSalary(employeeDto.getEmpSalary());
                emp.setEmpDesg(employeeDto.getEmpDesg());
                emp.setEmpPassword(employeeDto.getEmpPassword());
                emp.setAttendance(employeeDto.getAttendance());
                emp.setMonthlySalar(employeeDto.getMonthlySalar());

                empRepositery.save(emp);

                return "Employee Updated Successfully";
            }else{
                return "Employee Updation Failed";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "Internal server error ,Please contact to admin";
        }

    }//end emp updation

    //===========================================================================================================
 //To delete the Employee

    @Override
    public String deleteEmployee(int id) {
        try {
            Optional<Employee> option = empRepositery.findById(id);
            if(option.isPresent()){
                Employee emp=option.get();
                empRepositery.delete(emp);

                return "Employee Deleted Successfully";
            }else{
                return "Employee Deletion failed";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "Internal server error,please contact to Admin";
        }
    }//end of delete empl
    //===========================================================================================================
    //To calculate Final Salary of a month for a Emp Depending of  no of days he worked

    @Override
    public String calEmpGrossSalary(int id) {
        String finalSalary=null;
        try {
            Optional<Employee> option = empRepositery.findById(id);
            if (option.isPresent()) {
                Employee emp = option.get();
                double empSalary = emp.getEmpSalary();
                Attendance attendance = emp.getAttendance();
                int noOfWorkingDays = attendance.getNoOfWorkingDays();
                int totalDays = attendance.getTotalDays();
                double value=((double)noOfWorkingDays/totalDays)*empSalary;
                finalSalary=String.valueOf(value);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return finalSalary;
    }//end of method


    //=================================================================================================================

       //To Get Basic information of a particular Employee
    @Override
    public String getBasicInformation(int id) {
        String str=null;
        try{
            Optional<Employee> option = empRepositery.findById(id);
            if(option.isPresent()){
                Employee employee = option.get();
                int  empId = employee.getEmpId();
                  String strId=String.valueOf(empId);
                String empName = employee.getEmpName();
                String empDesg = employee.getEmpDesg();
                str="Employee Basic Details"+"\n"+"======================"+"\n"+"Employee ID:"+strId+"\n"+"Employee Name:"+empName+"\n"+"Employee Designation:"+empDesg;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return str;
    }//end of get basic information
    //=================================================================================================================
    //To get All Details of the Employee with id and password

    @Override
    public String getAllEmpInformation(int id, String password) {
        String str=null;
        try {
            Optional<Employee> option = empRepositery.findById(id);

            if(option.isPresent()){
                Employee employee = option.get();
                int empId = employee.getEmpId();
                String empName = employee.getEmpName();
                double empSalary = employee.getEmpSalary();
                String empDesg = employee.getEmpDesg();
                String empPassword = employee.getEmpPassword();
                Attendance attendance = employee.getAttendance();
                int totalDays = attendance.getTotalDays();
                int noOfWorkingDays = attendance.getNoOfWorkingDays();
                double monthlySalar = employee.getMonthlySalar();
                //  double monthlySalary =  (double) noOfWorkingDays/totalDays*empSalary;

                if(empId==id && empPassword.equals(password)) {
                    str= "Employee Complete details"+"\n"+"----------------------------------------------"+"\n"+"EmpId:"+empId+"\n"+"EmpName:"+empName+"\n"+
                                 "Emp Designation:"+empDesg+"\n"+"Emp Total Salarary:"+empSalary+"\n"+"Emp This Month Salary:"+monthlySalar+"\n"+
                            "TotalNumber Of Working Days:"+totalDays+"\n"+
                               "No Of Days Epm Work:"+noOfWorkingDays;
                    System.out.println(str);
                    return  str;
               }else{
                    return "Check The Id or Password,This Combination does not Found";
                }

            }else{
                    return "Check The Id or Password,This Combination does not Found";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "Internal Server Error ,Please Contact To Admin";
        }

    }//end of get all the details of emp
    //=================================================================================================================
    //To get the salary based on the attendance

    @Override
    public String monthlySalBasedOnAttendance(int id) {
         String  str=null;
        try {
            Optional<Employee> option = empRepositery.findById(id);
            if(option.isPresent()){
                Employee employee = option.get();

                double empSalary = employee.getEmpSalary();
                Attendance attendance = employee.getAttendance();
                int totalDays = attendance.getTotalDays();
                int noOfWorkingDays = attendance.getNoOfWorkingDays();

                if(noOfWorkingDays<24){
                    int howManyDaysMiss=24-noOfWorkingDays;
                    double v = empSalary / 30;
                    double  deductSalary = howManyDaysMiss * v;
                    double monthlySalary=empSalary-deductSalary;

                    str="Emp Salary for "+noOfWorkingDays+" Days is:"+String.valueOf(monthlySalary);

                }else{
                    str="Emp Salary for "+noOfWorkingDays+" Days is:"+String.valueOf(empSalary);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }//end of  monthly salary based on attendance

    //============================================================================================================

//This Method is for send the monthly salary of the emp while add the Employee(note-: directly write in serviceimpl class,not write in service interface)
    public double monthlySalBasedOnAttendance(double sal,int noofWorkingDays) {
        double monthlySalary = 0;
        try {
            if (noofWorkingDays < 24) {
                int howManyDaysMiss = 24 - noofWorkingDays;
                double v = sal / 30;
                double deductSalary = howManyDaysMiss * v;
                monthlySalary = sal - deductSalary;
            }else{
                return  sal;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monthlySalary;
    }//end of  monthly salary based on attendance

//============================================================================================================

}





