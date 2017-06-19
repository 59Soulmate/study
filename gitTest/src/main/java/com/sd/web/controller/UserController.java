package com.sd.web.controller;

import com.sd.entity.User;
import com.sd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sd-kf on 2017/6/9.
 */
@Controller
@RequestMapping("/user/*")
public class UserController {

    Map<String, Object> map = new HashMap<String, Object>();
    @Autowired
    UserService userService;

    @RequestMapping("findUser.action")
    public
    @ResponseBody
    Map<String, Object> findUser(HttpServletRequest request, HttpServletResponse response, Integer offset, Integer limit) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        map.put("tableName", "MyUser");
        Map<String, Object> args = request.getParameterMap();
        List<User> list = userService.findUser(offset, limit);
        Integer count = userService.getCount(map);
        map.clear();
        map.put("rows", list);
        map.put("total", count);
        return map;
    }
}
