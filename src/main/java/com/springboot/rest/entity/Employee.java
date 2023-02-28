package com.springboot.rest.entity;

import jakarta.persistence.*;

@Entity
@Table(name="emp")
public class Employee {

    @Id
    private int empId;

    private String empName;

    private double empSalary;

    private String empDesg;

    private String empPassword;

    private double monthlySalar;

    @OneToOne(cascade = CascadeType.ALL)
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

    public double getMonthlySalar() {
        return monthlySalar;
    }

    public void setMonthlySalar(double monthlySalar) {
        this.monthlySalar = monthlySalar;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public Employee() {
    }

    public Employee(int empId, String empName, double empSalary, String empDesg, String empPassword, Attendance attendance) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empDesg = empDesg;
        this.empPassword = empPassword;
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", empDesg='" + empDesg + '\'' +
                ", empPassword='" + empPassword + '\'' +
                ", attendance=" + attendance +
                '}';
    }

}
