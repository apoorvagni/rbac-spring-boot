package com.jianglijie.rbac.controller;

import com.jianglijie.rbac.entity.Result;
import com.jianglijie.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jianglj on 2017/5/8.
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestParam("user_name") String uname,
                        @RequestParam("password") String password){

        return userService.login(uname, password);
    }

}
