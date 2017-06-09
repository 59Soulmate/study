package com.sd.dao;

import com.sd.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by sd-kf on 2017/6/9.
 */
public interface UserDao {
    User login(@Param("name") String name,@Param("pass") String pass);
}
