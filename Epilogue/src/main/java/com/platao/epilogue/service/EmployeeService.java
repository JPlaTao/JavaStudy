package com.platao.epilogue.service;

import com.platao.epilogue.domain.Employee;
import com.platao.epilogue.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> findAll(){
        return employeeMapper.selectAll();
    }
}
