package com.test.importdatas.dao;

import com.test.importdatas.pojo.Student;
import com.test.importdatas.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaSpecificationExecutor<User>, JpaRepository<User,String> {
}
