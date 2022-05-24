package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.mapper.EduTeacherMapper;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author 以飞飞飞
 * @since 2022-04-08
 */
@Api(value = "教师管理")
@RestController
@CrossOrigin
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherMapper;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("/findAll")
    public R findAll(){
        List<EduTeacher> list = teacherMapper.list(null);
        Map map=new HashMap();
        map.put("list", list);
        return R.ok().data(map);
    }

    @ApiOperation(value = "逻辑删除教师")
    @DeleteMapping("{id}")
    public R removeTeacher(@ApiParam(name = "id",value = "讲师ID",required = true) @PathVariable String id){
        boolean flag = teacherMapper.removeById(id);
        if (flag){
            return R.ok().message("删除成功");
        }else {
            return R.error().message("删除失败");
        }
    }


    @GetMapping("pageTeacher/{pageNum}/{pageSize}")
    public R pageTeacher(@PathVariable Long pageNum,
                         @PathVariable Long pageSize){
        Page<EduTeacher> page=new Page<>(pageNum,pageSize);
        QueryWrapper<EduTeacher> wrapper=new QueryWrapper<>();

        teacherMapper.page(page, wrapper);
        Map map=new HashMap();
        long total = page.getTotal();//总记录数
        List<EduTeacher> records = page.getRecords();
        map.put("records",records);
        map.put("total",total);
        return R.ok().data("map",map);
    }


    @ApiOperation(value = "条件分页查询")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable Long current, @PathVariable Long limit
                                  , @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> pageTecher=new Page<>(current,limit);
        QueryWrapper<EduTeacher> wrapper=new QueryWrapper<>();
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String gmtCreate = teacherQuery.getGmtCreate();
        String gmtModified = teacherQuery.getGmtModified();
        if (!StringUtils.isEmpty(name)){
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)){
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(gmtCreate)){
            wrapper.ge("gmt_create", gmtCreate);
        }
        if (!StringUtils.isEmpty(gmtModified)){
            wrapper.le("gmt_modified", gmtModified);
        }
        teacherMapper.page(pageTecher, wrapper);
        List<EduTeacher> list = pageTecher.getRecords();
        return R.ok().data("list", list);
    }

    @ApiOperation(value = "添加用户信息")
    @PostMapping("eduTacherInsert")
    public R eduTacherInsert(@RequestBody(required = false)EduTeacher eduTeacher){

        boolean save = teacherMapper.save(eduTeacher);
        if (save){
            return R.ok().message("添加成功");
        }else {
            return R.error().message("添加失败");
        }
    }

    @ApiOperation(value = "根据ID查询修改信息")
    @GetMapping("getTacher/{id}")
    public R getTacher(@PathVariable String id){
        EduTeacher byId = teacherMapper.getById(id);
        return R.ok().data("list", byId);
    }

    @ApiOperation(value = "根据Id修改教师信息")
    @PostMapping("eduTacherUpdate")
    public R eduTacherUpdate(@RequestBody(required = false)EduTeacher eduTeacher){
        boolean flag = teacherMapper.updateById(eduTeacher);
        if(flag){
            return R.ok().message("修改成功");
        }else {
            return R.error().message("修改失败");
        }
    }


}

