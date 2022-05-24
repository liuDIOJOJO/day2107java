package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.Video.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author 以飞飞飞
 * @since 2022-04-21
 */
public interface EduChapterService extends IService<EduChapter> {

    List<Chapter> getChapterAndVideo(String courseid);

    void deleteChapter(String id);

    void removeDataById(String id);
}
