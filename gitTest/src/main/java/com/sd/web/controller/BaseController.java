package com.sd.web.controller;

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

    Map<String,Object> map=new HashMap<String, Object>();
    @Autowired
    UserService userService;

    @RequestMapping("login.action")
    public String login(){
        return "login";
    }

    @RequestMapping("index.action")
    public String index(String name,String pass){
//        map.put("name",name);
//        map.put("pass",pass);
        if(userService.login(name,pass)){
            return "index";
        }
        return "login";
    }
}
