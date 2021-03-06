package com.sd.service.impl;

import com.sd.dao.UserDao;
import com.sd.entity.User;
import com.sd.service.UserService;
import com.sd.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sd-kf on 2017/6/9.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public boolean login(String name, String pass) {
        User user = userDao.login(name, pass);
        if (user != null) {
            BaseController.map.put("user", user);
            return true;
        }
        return false;
    }

    public List<User> findUser(int page, int size) {
        return userDao.findUser(page, size);
    }

    public Integer getCount(Map<String, Object> map) {
        return userDao.getCount(map);
    }

    public User findUserByLogin(String username) {
        return userDao.findUserByLogin(username);
    }
}
