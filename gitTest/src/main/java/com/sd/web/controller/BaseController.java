package com.sd.web.controller;

import com.sd.entity.User;
import com.sd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
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

    @RequestMapping("index.action")
    public String index(String name, String pass) {
        if (userService.login(name, pass)) {
            User u=(User)map.get("user");
            return "index";
        }
        return "redirect:/login.jsp";
    }
}
