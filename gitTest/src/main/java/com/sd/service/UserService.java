package com.sd.service;

import com.sd.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by sd-kf on 2017/6/9.
 */
public interface UserService {

    boolean login(String name,String pass);

    List<User> findUser(int page, int size);

    Integer getCount(Map<String, Object> map);
}
