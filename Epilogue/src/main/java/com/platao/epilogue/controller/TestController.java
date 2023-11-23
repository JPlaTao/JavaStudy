package com.platao.epilogue.controller;

import com.platao.epilogue.domain.Result;
import static com.platao.epilogue.domain.Result.*;

import com.platao.epilogue.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/test")
    public Result test(){
        return success("成功");
    }

    @RequestMapping("/employees")
    public Result getTable(){
        return success("成功",employeeService.findAll());
    }
}
