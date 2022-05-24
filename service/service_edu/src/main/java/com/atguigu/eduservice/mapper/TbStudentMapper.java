package com.atguigu.eduservice.mapper;

import com.atguigu.eduservice.entity.TbStudent;
import com.atguigu.eduservice.entity.vo.Student;
import com.atguigu.eduservice.entity.vo.StudentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 以飞飞飞
 * @since 2022-04-29
 */
public interface TbStudentMapper extends BaseMapper<TbStudent> {

    List<Student> studentAll(StudentVo studentVo);
}
