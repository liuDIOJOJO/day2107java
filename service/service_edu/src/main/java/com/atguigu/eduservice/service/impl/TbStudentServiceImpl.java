package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.TbStudent;
import com.atguigu.eduservice.entity.vo.Student;
import com.atguigu.eduservice.entity.vo.StudentVo;
import com.atguigu.eduservice.mapper.TbStudentMapper;
import com.atguigu.eduservice.service.TbStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 以飞飞飞
 * @since 2022-04-29
 */
@Service
public class TbStudentServiceImpl extends ServiceImpl<TbStudentMapper, TbStudent> implements TbStudentService {

    @Override
    public List<Student> studentAll(StudentVo studentVo) {
        return baseMapper.studentAll(studentVo);
    }
}
