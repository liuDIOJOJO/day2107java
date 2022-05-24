package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.TbStudent;
import com.atguigu.eduservice.entity.vo.Student;
import com.atguigu.eduservice.entity.vo.StudentVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 以飞飞飞
 * @since 2022-04-29
 */
public interface TbStudentService extends IService<TbStudent> {

    List<Student> studentAll(StudentVo studentVo);
}
