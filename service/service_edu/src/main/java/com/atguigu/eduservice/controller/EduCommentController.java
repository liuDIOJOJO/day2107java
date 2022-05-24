package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.ViodClient;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author 以飞飞飞
 * @since 2022-04-21
 */
@RestController
@RequestMapping("/eduservice/edu-comment")
public class EduCommentController {

    @Autowired
    private ViodClient viodClient;

    @DeleteMapping("{id}")
    public void caonima(@PathVariable("id") String id){
        String[] split = id.split(",");
        List<String> list = Arrays.asList(split);
        R r = viodClient.removeAlyVideo(list);
    }
}

