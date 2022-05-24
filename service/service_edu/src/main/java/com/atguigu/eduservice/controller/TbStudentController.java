package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.TbStudent;
import com.atguigu.eduservice.entity.vo.Student;
import com.atguigu.eduservice.entity.vo.StudentVo;
import com.atguigu.eduservice.service.TbStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/eduservice/tb-student")
@CrossOrigin
public class TbStudentController {
    @Autowired
    private TbStudentService tbStudentService;

    @PostMapping("studentAll")
    public R studentAll(@RequestBody StudentVo studentVo){
        List<Student> list = tbStudentService.studentAll(studentVo);
        return R.ok().data("list", list);
    }

    @PostMapping("studentAdd")
    public R studentAdd(@RequestBody Student studentVo){
        TbStudent tbStuden=new TbStudent();
        BeanUtils.copyProperties(studentVo, tbStuden);
        tbStudentService.save(tbStuden);
        return R.ok();
    }
}

