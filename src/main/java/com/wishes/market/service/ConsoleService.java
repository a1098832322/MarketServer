package com.wishes.market.service;

import com.wishes.market.model.CommodityDo;
import com.wishes.market.model.UserDo;

import java.util.List;

/**
 * 后台配置接口Service
 *
 * @author 郑龙
 * @date 2019/2/28
 **/
public interface ConsoleService {
    /**
     * 添加一条商品信息
     *
     * @param commodity 商品信息
     * @return true/false
     */
    boolean addCommodity(CommodityDo commodity);

    /**
     * 列举出所有用户(管理员用)
     *
     * @return user List
     */
    List<UserDo> listUser();
}
