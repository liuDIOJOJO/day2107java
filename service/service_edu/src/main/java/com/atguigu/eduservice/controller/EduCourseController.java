package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    //添加课程基本信息的方法
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        //返回添加之后课程id，为了后面添加大纲使用
        String id = courseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId",id);
    }

    @GetMapping("getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId){
        CourseInfoVo courseInfoVo=courseService.getCourseInfo(courseId);
        return R.ok().data("courseInfoVo", courseInfoVo);
    }

    @PostMapping("updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        courseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id){
        EduCourse eduCourse=new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");
        courseService.updateById(eduCourse);
        return R.ok();
    }

    @GetMapping("getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id){
        CoursePublishVo list=courseService.getPublishCourseInfo(id);
        return R.ok().data("publishCourse",list);
    }

    @PostMapping("fuck/{current}/{limit}")
    public R caonimade(@RequestBody(required = false) EduCourse eduCourse,
                       @PathVariable  Long current,@PathVariable Long limit){
        Page<EduCourse> page=new Page<>(current,limit);
        String title = eduCourse.getTitle();
        String status = eduCourse.getStatus();
        QueryWrapper<EduCourse> wrapper=new QueryWrapper<>();
        if (!StringUtils.isEmpty(title)){
            wrapper.eq("title", title);
        }

        if (!StringUtils.isEmpty(status)){
            wrapper.eq("status", status);
        }

        IPage<EduCourse> pages = courseService.page(page, wrapper);
        List<EduCourse> records = pages.getRecords();
        return R.ok().data("list",records);
    }

    @DeleteMapping("removeDataById/{id}")
    public R removeDataById(@PathVariable String id){
        courseService.removeDataById(id);
        return R.ok();
    }
}

