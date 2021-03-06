package com.sd.dao;

import com.sd.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by sd-kf on 2017/6/9.
 */
public interface UserDao {
    User login(@Param("name") String name, @Param("pass") String pass);

    List<User> findUser(@Param("page") int page, @Param("size") int size);

    Integer getCount(Map<String, Object> map);

    User findUserByLogin(String username);
}
