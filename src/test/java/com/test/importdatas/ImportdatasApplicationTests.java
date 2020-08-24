package com.test.importdatas;

import com.test.importdatas.dao.UserInfoDao;
import com.test.importdatas.pojo.UserInfo;
import com.test.importdatas.util.Md5Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ImportdatasApplicationTests {
    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    void contextLoads() throws Exception {
        UserInfo userInfo = new UserInfo();
        String md5Password = Md5Utils.md5("1234", "cmd");
        userInfo.setGmtCreate(new Date());
        userInfo.setGmtModified(new Date());
        userInfo.setMd5Password(md5Password);
        userInfo.setPassword("1234");
        userInfo.setSalt("cmd");
        userInfo.setUserName("zs2");
//        userInfo.setVersion(1);
        userInfo.setRight("right");
        userInfo.setRole("role");
        userInfoDao.save(userInfo);
    }
    @Test
    public void testOneToOne(){
        List<UserInfo> all = userInfoDao.findAll();
        all.forEach(System.out::println);
    }
    @Test
    public void testGetLists(){
        List<Map> all = userInfoDao.getLists();
        all.forEach(System.out::println);
    }

}
