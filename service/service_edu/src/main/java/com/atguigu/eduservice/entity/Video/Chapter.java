package com.atguigu.eduservice.entity.Video;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人: 以飞飞飞
 * 创建日期: 2022/4/24 11:06
 */
@Data
public class Chapter {

    @ApiModelProperty(value = "课程ID")
    private String id;

    @ApiModelProperty(value = "章节名称")
    private String title;

    @ApiModelProperty(value = "章节下小节名称")
    private List<Video> list=new ArrayList<>();
}
