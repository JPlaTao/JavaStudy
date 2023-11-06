package com.platao.mybatis.controller;

import com.github.pagehelper.PageInfo;
import com.platao.mybatis.model.Student;
import com.platao.mybatis.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CRUDController {

    @Autowired
    Service service;

//    @RequestMapping("/students")
//    public ModelAndView studentList() {
//        List<Student> studentList = service.findAll();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("studentList", studentList);
//        modelAndView.setViewName("studentList");
//        return modelAndView;
//    }

    @RequestMapping("/students")
    public ModelAndView studentPagingList(Integer num) {
        if (num == null){
            num = 1;
        }
        PageInfo<Student> page = service.findOnePage(num, 5);
        ModelAndView modelAndView = new ModelAndView();
        // 传递分页数据
        modelAndView.addObject("page", page);
        modelAndView.setViewName("studentList");
        return modelAndView;
    }

    @RequestMapping("/student/remove")
    public String studentDelete(int id) {
        int i = service.removeOneByID(id);
        return "redirect:/students";
    }

    @PostMapping("/student/update")
    public String studentUpdate(Student student){
        service.update(student);
        return "redirect:/students";
    }
}
