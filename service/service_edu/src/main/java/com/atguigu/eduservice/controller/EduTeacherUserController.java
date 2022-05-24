package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建人: 刘百顺
 * 创建日期: 2022/4/15 10:57
 */
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduTeacherUserController {

    @PostMapping("login")
    public R login() {
        return R.ok().data("token","admin");
    }

    @RequestMapping("info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}

