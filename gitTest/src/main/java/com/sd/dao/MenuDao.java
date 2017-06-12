package com.sd.dao;

import com.sd.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sd-kf on 2017/6/12.
 */
public interface MenuDao {
    List<Menu> queryMenuByHome(@Param("userid") Integer userid, @Param("fid") Integer fid);
}
