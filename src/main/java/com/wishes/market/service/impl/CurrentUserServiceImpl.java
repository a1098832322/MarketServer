package com.wishes.market.service.impl;

import org.springframework.stereotype.Service;

import com.wishes.market.dto.PrivilegeInfo;
import com.wishes.market.service.CurrentUserService;

/**
 * 登录用户服务类
 *
 * @author huangt
 * @create 2018-02-01 18:34
 **/
@Service
public class CurrentUserServiceImpl implements CurrentUserService {
    private static final ThreadLocal<PrivilegeInfo> THREAD_LOCAL = new ThreadLocal<>();

    @Override
    public PrivilegeInfo getPvgInfo() {
        return THREAD_LOCAL.get();
    }

    @Override
    public void setPvginfo(PrivilegeInfo privilegeInfo) {
        THREAD_LOCAL.set(privilegeInfo);
    }

    @Override
    public void clean() {
        THREAD_LOCAL.remove();
    }

}
