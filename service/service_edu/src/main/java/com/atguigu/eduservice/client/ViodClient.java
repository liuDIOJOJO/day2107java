package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 创建人: 以飞飞飞
 * 创建日期: 2022/4/28 14:05
 */
@FeignClient("service-vod")
@ComponentScan
public interface ViodClient {
    @DeleteMapping("/eduvod/video/removeAlyVideo")
    public R removeAlyVideo(@RequestParam("voideid") List<String> voideid);
}
