package com.atguigu.eduservice.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * 创建人: 以飞飞飞
 * 创建日期: 2022/4/29 10:40
 */
@Data
public class Student {
    private String sid;

    private String sname;

    private Integer age;

    private Date birthday;

    private Integer proid;

    private Integer cityid;

    private Integer couid;

    private String address;

    private Integer gid;

    private String gname;

    private String cname;
}
