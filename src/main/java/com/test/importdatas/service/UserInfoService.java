package com.test.importdatas.service;

import com.test.importdatas.dao.UserInfoDao;
import com.test.importdatas.pojo.UserInfo;
import com.test.importdatas.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    public boolean create(String userName, String password) throws Exception {
        String md5Password = Md5Utils.md5(password, "cmd");
        UserInfo userInfo = new UserInfo();
        userInfo.setGmtCreate(new Date());
        userInfo.setMd5Password(md5Password);
        userInfo.setPassword(password);
        userInfo.setSalt("cmd");
        userInfo.setUserName(userName);
//        userInfo.setVersion(1);
        UserInfo save = userInfoDao.save(userInfo);
        if(save!=null){
            return true;
        }else {
            return false;
        }
    }
}
