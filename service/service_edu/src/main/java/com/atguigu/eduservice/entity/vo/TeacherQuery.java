package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;

/**
 * 创建人: 刘百顺
 * 创建日期: 2022/4/8 13:37
 */
@Data
public class TeacherQuery {
    @ApiModelProperty(value = "名字信息模糊查询")
    private String name;
    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;
    @ApiModelProperty(value = "开始", example = "2019-12-01 10:10:10")
    private String gmtCreate;
    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String gmtModified;

}
