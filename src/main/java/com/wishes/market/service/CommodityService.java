package com.wishes.market.service;

import com.wishes.market.model.CommodityTypeDo;

import java.util.List;

/**
 * 商品service
 *
 * @author 郑龙
 * @date 2019-01-24  16:41
 */
public interface CommodityService {

    /**
     * 是否存在商品
     *
     * @param cId 商品id
     * @return true/false
     */
    boolean isExistCommodity(Long cId);

    /**
     * 是否存在商品
     *
     * @param cName 商品名称
     * @return true/false
     */
    boolean isExistCommodity(String cName);

    /**
     * 查询商品类别列表
     *
     * @return CommodityType List
     */
    List<CommodityTypeDo> queryCommodityTypes();
}
