package com.springboot.rest.controller;

import com.springboot.rest.dto.AttendanceDto;
import com.springboot.rest.service.inter.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    //===================================================================================================================
    //To add or Insert The Attendance
    @PostMapping("/attendance")
    public String addAttendance(@RequestBody AttendanceDto attendanceDto) {
        return attendanceService.addAttendance(attendanceDto);
    }
    //===================================================================================================================
    //To get Attandance bY Id

    @GetMapping("/attendance/{id}")
    public AttendanceDto getAttendanceById(@PathVariable int id) {
        return attendanceService.getAttendanceById(id);
    }
    //===================================================================================================================
    //To get All the Attendance
    @GetMapping("/attendance")
    public List<AttendanceDto> getAllAttendance() {
        return  attendanceService.getAllAttendance();
    }
//===================================================================================================================
    //To Update the Attendance
    @PutMapping("/attendance")
public String updateAttendance(@RequestBody AttendanceDto attendanceDto) {
        return  attendanceService.updateAttendance(attendanceDto);
   }
   //===================================================================================================================
    //to Delete the Attendance
    @DeleteMapping("/attendance/{id}")
   public String deleteAttendance(@PathVariable int id) {
        return attendanceService.deleteAttendance(id);
   }
    //===================================================================================================================
}
