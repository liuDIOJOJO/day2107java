package com.atguigu.cmsservice.service;

import com.atguigu.cmsservice.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author 以飞飞飞
 * @since 2022-05-03
 */
public interface CrmBannerService extends IService<CrmBanner> {

    List<CrmBanner> listbyId();
}
