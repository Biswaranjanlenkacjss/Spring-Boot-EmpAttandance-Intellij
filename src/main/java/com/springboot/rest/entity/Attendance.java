package com.springboot.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emp_attendance")
public class Attendance {

    @Id
    private int id;

    private  int totalDays;

    private int noOfWorkingDays;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", totalDays=" + totalDays +
                ", noOfWorkingDays=" + noOfWorkingDays +
                '}';
    }

    public int getNoOfWorkingDays() {
        return noOfWorkingDays;
    }

    public void setNoOfWorkingDays(int noOfWorkingDays) {
        this.noOfWorkingDays = noOfWorkingDays;
    }

    public Attendance() {
    }

    public Attendance(int id, int totalDays, int noOfWorkingDays) {
        this.id = id;
        this.totalDays = totalDays;
        this.noOfWorkingDays = noOfWorkingDays;
    }


}
