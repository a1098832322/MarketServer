package com.wishes.market.dto;

import lombok.Data;

/**
 * 购物车或已购买商品Model
 *
 * @author 郑龙
 */
@Data
public class CartDto {
    /**
     * 商品id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 商品类别id
     */
    private Integer commodityType;

    /**
     * 商品价格
     */
    private Double commodityPrice;

    /**
     * 商品总量
     */
    private Long commodityTotal;

    /**
     * 商品剩余
     */
    private Long commoditySurplus;

    /**
     * 数据是否被删除
     */
    private String isDeleted;

    /**
     * 商品描述
     */
    private String commodityInfo;

    /**
     * 商品图片(Base64编码)
     */
    private String commodityImg;

    /**
     * 购买数量
     */
    private Integer number;

    /**
     * 总花费
     */
    private Double totalPrice;

}