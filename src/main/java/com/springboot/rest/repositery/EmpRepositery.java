package com.springboot.rest.repositery;

import com.springboot.rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepositery extends JpaRepository<Employee,Integer> {

}
