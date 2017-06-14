package com.sd.web.controller;

import com.sd.entity.Menu;
import com.sd.entity.User;
import com.sd.service.MenuService;
import com.sd.service.UserService;
import com.sd.utils.TreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sd-kf on 2017/6/9.
 */
@Controller
@RequestMapping("/front/*")
public class BaseController {

    public static Map<String, Object> map = new HashMap<String, Object>();
    @Autowired
    UserService userService;
    @Autowired
    MenuService menuService;

    @RequestMapping("index.action")
    public String index(String name, String pass) {
        if (userService.login(name, pass)) {
            return "index";
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("powerManage.action")
    public String powerManage() {
        return "powerManage.jsp";
    }

    @RequestMapping("loadTree.action")
    public
    @ResponseBody
    List<TreeVo> loadTree(Integer id) {
        User u = (User) map.get("user");
        List<TreeVo> list = menuService.queryMenuByHome(u.getUser_id(), id);
        return list;
    }


}
