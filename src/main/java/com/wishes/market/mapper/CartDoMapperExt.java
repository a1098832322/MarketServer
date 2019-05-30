package com.wishes.market.mapper;

import com.wishes.market.dto.CartDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购物车SQL扩展
 *
 * @author zl
 * @date 2019年1月25日11:31:38
 */
public interface CartDoMapperExt extends CartDoMapper {
    /**
     * 查询购物车/购买记录表
     *
     * @param uId       用户id
     * @param purchased 数据类型
     * @param start     开始值
     * @param offset    分页数据长度
     * @return 结果集
     */
    List<CartDto> queryCart(@Param("uId") Long uId,
                            @Param("purchased") Long purchased,
                            @Param("start") int start,
                            @Param("offset") int offset);

    /**
     * 根据条件统计数据数量
     *
     * @param uId       用户id
     * @param purchased 数据类型
     * @return 统计数
     */
    Integer countCart(@Param("uId") Long uId,
                      @Param("purchased") Long purchased);
}