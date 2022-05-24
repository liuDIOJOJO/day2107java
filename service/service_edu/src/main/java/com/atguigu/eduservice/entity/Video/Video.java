package com.atguigu.eduservice.entity.Video;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 创建人: 以飞飞飞
 * 创建日期: 2022/4/24 11:09
 */
@Data
public class Video {
    @ApiModelProperty(value = "课程ID")
    private String id;

    @ApiModelProperty(value = "章节名称")
    private String title;
}
