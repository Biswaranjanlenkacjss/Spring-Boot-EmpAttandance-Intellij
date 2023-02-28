package com.springboot.rest.service;

import com.springboot.rest.dto.AttendanceDto;
import com.springboot.rest.entity.Attendance;
import com.springboot.rest.repositery.AttendanceRepositery;
import com.springboot.rest.service.inter.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceRepositery attenRepo;
    //============================================================================================================
    //To Add or insert Attendance
    @Override
    public String addAttendance(AttendanceDto attendanceDto) {
        try {
            Attendance attendance=new Attendance();

            attendance.setId(attendanceDto.getId());
            attendance.setNoOfWorkingDays(attendanceDto.getNoOfWorkingDays());
            attendance.setTotalDays(attendanceDto.getTotalDays());


            if(Objects.nonNull(attendance.getId())){
                attendance=attenRepo.save(attendance);
                return "Attendance Added Successfully";
            }else{
                return "Attendance Addtion Failed";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "Internal Server Error,Contact To Admin";
        }

    }//end of Add Attendance
    //============================================================================================================
    //To Get Attendance By Id

    @Override
    public AttendanceDto getAttendanceById(int id) {
        AttendanceDto attDto=null;
        try{
            Optional<Attendance> option = attenRepo.findById(id);

            if(option.isPresent()){
                Attendance attendance = option.get();
                attDto=new AttendanceDto();
                attDto.setId(attendance.getId());
                attDto.setNoOfWorkingDays(attendance.getNoOfWorkingDays());
                attDto.setTotalDays(attendance.getTotalDays());
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return attDto;
    }//end of  add attaindance By Id
    //============================================================================================================

    //To get All the Attendance
    @Override
    public List<AttendanceDto> getAllAttendance() {
        List< AttendanceDto> attDtoList=new ArrayList<>();
        try {
            List<Attendance> allAttendance = attenRepo.findAll();
            for(Attendance a:allAttendance){
                AttendanceDto dto=new AttendanceDto();
                dto.setId(a.getId());
                dto.setNoOfWorkingDays(a.getNoOfWorkingDays());
                dto.setTotalDays(a.getTotalDays());

                attDtoList.add(dto);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return attDtoList;
    }//end of get all the Attendance
    //============================================================================================================
    //To Update The Attendance

    @Override
    public String updateAttendance(AttendanceDto attendanceDto) {
        try {
            Optional<Attendance> option = attenRepo.findById(attendanceDto.getId());
            if(option.isPresent()) {
                Attendance attendance = option.get();
                attendance.setId(attendanceDto.getId());
                attendance.setNoOfWorkingDays(attendanceDto.getNoOfWorkingDays());
                attendance.setTotalDays(attendanceDto.getTotalDays());

                attenRepo.save(attendance);

                return "Attendance Updated Successfully";
            }
                else{
                    return "Attendance Updation Failed";
                }

        }catch (Exception e){
            e.printStackTrace();
            return "Internal Server Error ,please contact to Admin";
        }

    }//end of update the Attendance
    //============================================================================================================
    //To Delete The Attendance

    @Override
    public String deleteAttendance(int id) {
        try{
            Optional<Attendance> option = attenRepo.findById(id);
            if(option.isPresent()){
                Attendance attendance = option.get();
                attenRepo.delete(attendance);

                return  "Attendance Deleted Successfully";
            }else{
                return  "Attendance Deletion Failed";
            }

        }catch(Exception e){
            e.printStackTrace();
            return  "Internal Server Error,Please Contact to Admin";
        }

    }//end of delete  attendance
    //============================================================================================================

}
