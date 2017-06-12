package com.sd.service;

import com.sd.entity.Menu;
import com.sd.utils.TreeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sd-kf on 2017/6/12.
 */
public interface MenuService {

    List<TreeVo> queryMenuByHome(@Param("userid") Integer userid, @Param("fid") Integer fid);
}
