package com.atguigu.eduservice.entity.easy;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 创建人: 以飞飞飞
 * 创建日期: 2022/4/19 19:05
 */
@Data
public class SubjectData {
    @ExcelProperty(index = 0)
    private String oneSubjectName;
    @ExcelProperty(index = 1)
    private String twoSubjectName;
}
