package com.sd.service.impl;

import com.sd.dao.MenuDao;
import com.sd.entity.Menu;
import com.sd.service.MenuService;
import com.sd.utils.TreeVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sd-kf on 2017/6/12.
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    public List<TreeVo> queryMenuByHome(@Param("userid") Integer userid, @Param("fid") Integer fid) {
        if (fid == null) {
            fid = 0;
        }
        List<Menu> listMenu = menuDao.queryMenuByHome(userid, fid);
        List<TreeVo> listPower = new ArrayList<TreeVo>();
        for (Menu m : listMenu) {
            TreeVo vo=new TreeVo();
            vo.setId(m.getM_id());
            vo.setName(m.getM_name());
            vo.setFid(m.getM_fid());
            vo.setDescribe(m.getM_describe());
            vo.setFun(m.getM_fun());
            List<Menu> list = menuDao.queryMenuByHome(userid, m.getM_id());
            if (list.size() == 0) {
                vo.setIsParent(false);
            }
            listPower.add(vo);
        }
        return listPower;
    }
}
