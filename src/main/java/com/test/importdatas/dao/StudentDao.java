package com.test.importdatas.dao;

import com.test.importdatas.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentDao extends JpaSpecificationExecutor<Student>, JpaRepository<Student,Long> {
}
