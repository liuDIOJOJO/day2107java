package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.Video.Chapter;
import com.atguigu.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author 以飞飞飞
 * @since 2022-04-21
 */
@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
public class EduChapterController {
    @Autowired
    private EduChapterService eduChapterService;

    @GetMapping("getChapterVideo/{courseid}")
    public R getChapterAndVideo(@PathVariable String courseid){
        List<Chapter> list=eduChapterService.getChapterAndVideo(courseid);
        return R.ok().data("list", list);
    }

    //添加章节
    @PostMapping("addChapter")
    public R addChapter(@RequestBody EduChapter eduChapter) {
        eduChapterService.save(eduChapter);
        return R.ok();
    }

    @DeleteMapping("{id}")
    public R deleteChapter(@PathVariable String id){
        eduChapterService.deleteChapter(id);
        return R.ok();
    }

    @ApiModelProperty(value = "根据id查询章节信息")
    @GetMapping("getChapterInfo/{chapterId}")
    public R getChapterInfo(@PathVariable String chapterId){

        EduChapter byId = eduChapterService.getById(chapterId);
        return R.ok().data("chapter", byId);
    }

    @PostMapping("updateChapter")
    public R updateChapter(@RequestBody EduChapter eduChapter){
        boolean b = eduChapterService.updateById(eduChapter);
        if (b){
            return R.ok().message("修改成功");
        }else {
            return R.error().message("修改失败");
        }

    }
}

