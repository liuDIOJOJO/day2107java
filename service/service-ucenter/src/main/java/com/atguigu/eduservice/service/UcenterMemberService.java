package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.UcenterMember;
import com.atguigu.eduservice.entity.Vo.LoginVo;
import com.atguigu.eduservice.entity.Vo.RegisterVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author 以飞飞飞
 * @since 2022-05-04
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(LoginVo loginVo);

    void register(RegisterVo registerVo);


    UcenterMember getOpenIdMember(String openid);
}
