package com.springboot.rest.service.inter;

import com.springboot.rest.dto.AttendanceDto;

import java.util.List;

public interface AttendanceService {

    //To Create Or Insert The Attendance
    public String addAttendance(AttendanceDto attendanceDto);


    //To Get Attendance By Id
    public AttendanceDto getAttendanceById(int id);


    //To get All the Attendance
    public List<AttendanceDto>  getAllAttendance();

    //To Update The Attendance
    public String updateAttendance(AttendanceDto attendanceDto);


    //To Delete The Attaendance
    public String deleteAttendance(int id);

}
