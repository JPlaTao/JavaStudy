package com.platao.epilogue.mapper;

import com.platao.epilogue.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void selectAll() {
        List<Employee> employees = employeeMapper.selectAll();
    }

    @Test
    void selectByPrimaryKey() {
        Employee employee = employeeMapper.selectByPrimaryKey(1l);
    }
}