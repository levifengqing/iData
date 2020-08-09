package com.test.importdatas.controller;

import com.test.importdatas.pojo.Student;
import com.test.importdatas.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("findAll")
    public String findAll(){
        studentService.findAll();
        return "findAll";
    }
    @GetMapping("saveOne")
    public String saveOne(String name,String bodyColor,int age,String sex){
        boolean b = studentService.saveOne(name, bodyColor, age, sex);
        if(b){
            return "save success";
        }
        return "save fail";
    }
    @GetMapping("login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("studentLogin");
        mv.addObject("name","student_1");
        Student student = new Student();
        student.setSex("nan");
        student.setBodyColor("blue");
        student.setName("levi");
        student.setAge(24);
        mv.addObject("user",student);
        return mv;
    }

}
