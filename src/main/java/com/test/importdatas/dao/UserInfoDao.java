package com.test.importdatas.dao;

import com.test.importdatas.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UserInfoDao extends JpaRepository<UserInfo,Long>, JpaSpecificationExecutor<UserInfo> {
    @Query(nativeQuery = true,value = "select * from user_info u left join user_home h on u.id = h.home_user")
    public List<Map> getLists();
}
