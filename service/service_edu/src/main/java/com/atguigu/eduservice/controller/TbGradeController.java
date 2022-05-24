package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.TbGrade;
import com.atguigu.eduservice.service.TbGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/eduservice/tb-grade")
public class TbGradeController {

    @Autowired
    private TbGradeService tbGradeService;
    @GetMapping
    public R getGrade(){
        List<TbGrade> list = tbGradeService.list(null);
        return R.ok().data("list",list);
    }
}

