package com.kfm.springstudent.controller;

import com.kfm.springstudent.model.Page;
import com.kfm.springstudent.model.Student;
import com.kfm.springstudent.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService = new StudentService();

    // 查询所有信息
    @GetMapping("/studentList")
    public String selectAll(
            HttpServletRequest request
    ) {
        List<Student> students = studentService.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("students", students);
        return "studentList";
    }

    @RequestMapping("/studentsOnPage")
    public ModelAndView showOnePage(
            @RequestParam(required = false) Integer currentPageNumber,
            Student student
    ) {
        ModelAndView mv = new ModelAndView();
        //查询一页信息
        if(student == null){
            student = new Student();
        }
        mv.addObject("condition",student);
        Page<Student> onePage = studentService.findOnePage(
                null,currentPageNumber);
        mv.addObject("onePageList",onePage.getOnePageDataList());
        mv.addObject("page", onePage);
        mv.setViewName("studentsOnPage");
        return mv;
    }

    @RequestMapping("/studentsOnPage/withCondition")
    public ModelAndView showOnePageWithCondition(
            @RequestParam(required = false) Integer currentPageNumber,
            Student student
    ) {
        ModelAndView mv = new ModelAndView();
        //查询一页信息
        if(student == null){
            student = new Student();
        }
        Page<Student> onePage = studentService.findOnePageWithCondition(
                null,currentPageNumber,student);
        mv.addObject("onePageList",onePage.getOnePageDataList());
        mv.addObject("page", onePage);

        mv.addObject("condition",student);
        mv.setViewName("studentsOnPage");
        return mv;
    }

    // 添加信息
    @GetMapping("/addStudent")
    public String addStudent() {
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudentSubmit(
            String name,
            Integer age,
            String gender,
            String grande,
            RedirectAttributes attributes
    ) {
        int rows = studentService.insertStudent(name, age, gender, grande);
        if (rows > 0) {
            attributes.addFlashAttribute("msg", "添加成功");
            return "redirect:/studentList";
        }
        attributes.addFlashAttribute("msg", "添加失败");
        return "redirect:/studentList";
    }

    // 删除信息
    @GetMapping("/deleteStudent")
    public String deleteStudentSubmit(String id, RedirectAttributes attributes) {
        int studentId = Integer.parseInt(id);
        int i = studentService.deleteStudent(studentId);
        if (i > 0) {
            attributes.addFlashAttribute("msg", "删除成功");
            return "redirect:/studentList";
        }
        attributes.addFlashAttribute("msg", "删除失败");
        return "redirect:/studentList";
    }

    // 修改信息
    @GetMapping("/editStudent")
    public String editStudent(String id, HttpSession session) {
        Student student = studentService.findById(id);
        session.setAttribute("student", student);
        return "editStudent";
    }

    @PostMapping("/editStudent")
    public String editStudentSubmit(RedirectAttributes attributes, HttpSession session, String name, int age, String gender, String grande) {
        Student student = (Student) session.getAttribute("student");
        int i = studentService.updateStudent(student.getId(), name, age, gender, grande);
        if (i > 0) {
            attributes.addFlashAttribute("msg", "修改成功");
            return "redirect:/studentList";
        }
        attributes.addFlashAttribute("msg", "修改失败");
        return "redirect:/studentList";
    }
}

