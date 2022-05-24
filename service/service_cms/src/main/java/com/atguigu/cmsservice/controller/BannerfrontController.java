package com.atguigu.cmsservice.controller;

import com.atguigu.cmsservice.entity.CrmBanner;
import com.atguigu.cmsservice.service.CrmBannerService;
import com.atguigu.commonutils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 创建人: 以飞飞飞
 * 创建日期: 2022/5/3 15:11
 *  前台访问接口
 */
@RestController
@RequestMapping("/cmsservice/bannerfront")
@CrossOrigin
public class BannerfrontController {

    @Autowired
    private CrmBannerService crmBannerService;

    @GetMapping("getAllBanner")
    public R index() {
        List<CrmBanner> list = crmBannerService.listbyId();
        return R.ok().data("bannerList", list);
    }

    public static void main(String[] args) {
        System.out.println("Hello Python");
    }
}
