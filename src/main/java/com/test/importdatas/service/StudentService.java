package com.test.importdatas.service;

import com.test.importdatas.dao.StudentDao;
import com.test.importdatas.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    public void findAll(){
        List<Student> all = studentDao.findAll();
        all.forEach(System.out::println);
    }
    public boolean saveOne(String name,String bodyColor,int age,String sex){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        student.setBodyColor(bodyColor);
        Student save = studentDao.save(student);
        if(StringUtils.isEmpty(save)){
            return false;
        }
        return true;
    }
}
