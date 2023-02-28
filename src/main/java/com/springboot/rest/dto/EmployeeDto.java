package com.springboot.rest.dto;

import com.springboot.rest.entity.Attendance;

public class EmployeeDto {
    private int empId;

    private String empName;

    private double empSalary;

    private String empDesg;

    private String empPassword;

    private double monthlySalar;

    private Attendance attendance;


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpDesg() {
        return empDesg;
    }

    public void setEmpDesg(String empDesg) {
        this.empDesg = empDesg;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }


    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public double getMonthlySalar() {
        return monthlySalar;
    }

    public void setMonthlySalar(double monthlySalar) {
        this.monthlySalar = monthlySalar;
    }

    public EmployeeDto() {
    }

    public EmployeeDto(int empId, String empName, double empSalary, String empDesg, String empPassword, Attendance attendance) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empDesg = empDesg;
        this.empPassword = empPassword;
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", empDesg='" + empDesg + '\'' +
                ", empPassword='" + empPassword + '\'' +
                ", attendance=" + attendance +
                '}';
    }



}
