package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.TbCity;
import com.atguigu.eduservice.service.TbCityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 以飞飞飞
 * @since 2022-04-29
 */
@RestController
@RequestMapping("/eduservice/tb-city")
public class TbCityController {

    @Autowired
    private TbCityService tbCityService;

    @GetMapping("{pid}")
    public R getCityAndPid(@PathVariable String pid){
        QueryWrapper<TbCity> wrapper=new QueryWrapper<>();
        wrapper.eq("pid", pid);
        List<TbCity> list = tbCityService.list(wrapper);
        return R.ok().data("pid", list);
    }
}

