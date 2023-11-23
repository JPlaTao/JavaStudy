package com.platao.epilogue.service;

import com.platao.epilogue.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void findAllTest(){
        List<Employee> all = employeeService.findAll();
        assertNotNull(all);
    }

}