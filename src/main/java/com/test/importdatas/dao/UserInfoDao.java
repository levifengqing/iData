package com.test.importdatas.dao;

import com.test.importdatas.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserInfoDao extends JpaRepository<UserInfo,Long>, JpaSpecificationExecutor<UserInfo> {
}
