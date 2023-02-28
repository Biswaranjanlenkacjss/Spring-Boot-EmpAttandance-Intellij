package com.springboot.rest.repositery;

import com.springboot.rest.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepositery extends JpaRepository<Attendance,Integer> {
}
