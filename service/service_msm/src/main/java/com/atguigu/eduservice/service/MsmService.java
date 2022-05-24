package com.atguigu.eduservice.service;

import java.util.Map;

/**
 * 创建人: 以飞飞飞
 * 创建日期: 2022/5/4 16:09
 */
public interface MsmService {

    boolean send(Map<String, Object> param, String phone);
}
