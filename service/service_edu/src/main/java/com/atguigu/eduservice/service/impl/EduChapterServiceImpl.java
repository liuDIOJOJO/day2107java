package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.entity.Video.Chapter;
import com.atguigu.eduservice.entity.Video.Video;
import com.atguigu.eduservice.mapper.EduChapterMapper;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebace.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author 以飞飞飞
 * @since 2022-04-21
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService eduVideoService;

    @Override
    public List<Chapter> getChapterAndVideo(String courseid) {

        QueryWrapper<EduChapter> wrapper=new QueryWrapper<>();
        wrapper.eq("course_id", courseid);
        List<EduChapter> educhapter = baseMapper.selectList(wrapper);


        QueryWrapper<EduVideo> videoWrapper=new QueryWrapper<>();
        videoWrapper.eq("course_id", courseid);
        List<EduVideo> eduVideo = eduVideoService.list(videoWrapper);

        List<Chapter> list=new ArrayList<>();
        for (int i = 0; i < educhapter.size(); i++) {
            Chapter chapter=new Chapter();
            EduChapter eduChapter = educhapter.get(i);
            BeanUtils.copyProperties(eduChapter, chapter);
            list.add(chapter);
            List<Video> videoList=new ArrayList<>();
            for (int m = 0; m < eduVideo.size(); m++) {
                EduVideo video = eduVideo.get(m);
                if (eduChapter.getId().equals(video.getChapterId())){
                    Video ok=new Video();
                    BeanUtils.copyProperties(video, ok);
                    videoList.add(ok);
                }
            }
            chapter.setList(videoList);
        }
        return list;
    }

    @Override
    public void deleteChapter(String id) {
        int delete = baseMapper.deleteById(id);
        if(delete==0){
            throw new GuliException(20001,"修改课程信息失败");
        }

        QueryWrapper<EduVideo> wrapper=new QueryWrapper<>();
        wrapper.eq("chapter_id", id);
        boolean remove = eduVideoService.remove(wrapper);
        if(!remove){
            throw new GuliException(20001,"修改课程信息失败");
        }
    }

    @Override
    public void removeDataById(String id) {
        QueryWrapper<EduChapter> wrapper=new QueryWrapper<>();
        wrapper.eq("course_id", id);
        baseMapper.delete(wrapper);
    }
}
