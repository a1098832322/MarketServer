package com.wishes.market.service;

import com.wishes.market.dto.PrivilegeInfo;

/**
 * @Auther: zhongyu
 * @Date: 2018/6/3 20:23
 * @Description:
 */
public interface CurrentUserService {
    PrivilegeInfo getPvgInfo();

    void setPvginfo(PrivilegeInfo privilegeInfo);

    void clean();
}
