package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author 以飞飞飞
 * @since 2022-04-21
 */
public interface EduVideoService extends IService<EduVideo> {

    void removeDataById(String id);
}
