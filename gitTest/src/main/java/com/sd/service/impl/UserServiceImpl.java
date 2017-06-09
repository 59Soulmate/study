package com.sd.service.impl;

import com.sd.dao.UserDao;
import com.sd.entity.User;
import com.sd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by sd-kf on 2017/6/9.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public boolean login(String name,String pass) {
        if (userDao.login(name,pass) != null) {
            return true;
        }
        return false;
    }
}
