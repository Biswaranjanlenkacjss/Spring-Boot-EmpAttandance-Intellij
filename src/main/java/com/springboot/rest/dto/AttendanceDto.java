package com.springboot.rest.dto;

public class AttendanceDto {

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

    public int getNoOfWorkingDays() {
        return noOfWorkingDays;
    }

    public void setNoOfWorkingDays(int noOfWorkingDays) {
        this.noOfWorkingDays = noOfWorkingDays;
    }

    public AttendanceDto() {
    }

    public AttendanceDto(int id, int totalDays, int noOfWorkingDays) {
        this.id = id;
        this.totalDays = totalDays;
        this.noOfWorkingDays = noOfWorkingDays;
    }

    @Override
    public String toString() {
        return "AttendanceDto{" +
                "id=" + id +
                ", totalDays=" + totalDays +
                ", noOfWorkingDays=" + noOfWorkingDays +
                '}';
    }

}
