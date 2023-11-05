package com.platao.mybatis.controller;

import com.platao.mybatis.model.Student;
import com.platao.mybatis.service.Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CRUDController {

    Service service = new Service();

    @RequestMapping("/students")
    public ModelAndView studentList() {
        List<Student> studentList = service.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentList", studentList);
        modelAndView.setViewName("studentList");
        return modelAndView;
    }

    @RequestMapping("/students/pagingList")
    public ModelAndView studentPagingList() {

        return null;
    }

    @RequestMapping("/student/remove")
    public String studentDelete(int id) {
        int i = service.removeOneByID(id);
        return "redirect:/students";
    }
}
