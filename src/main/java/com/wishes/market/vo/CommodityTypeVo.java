package com.wishes.market.vo;

import lombok.Data;

/**
 * 商品类型Vo
 *
 * @author 郑龙
 * @date 2019/3/21 11:32
 */
@Data
public class CommodityTypeVo {
    /**
     * 商品类别自增id
     */
    private Long id;

    /**
     * 商品类别解释
     */
    private String name;

    /**
     * 图标地址
     */
    private String iconPath;
}
