package com.wishes.market.mapper;

import com.wishes.market.model.CartDo;
import com.wishes.market.model.CartDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartDoMapper {
    /**
     *
     * @mbg.generated 2019-01-24
     */
    long countByExample(CartDoExample example);

    /**
     *
     * @mbg.generated 2019-01-24
     */
    int deleteByPrimaryKey(CartDo record);

    /**
     *
     * @mbg.generated 2019-01-24
     */
    int insert(CartDo record);

    /**
     *
     * @mbg.generated 2019-01-24
     */
    int insertSelective(CartDo record);

    /**
     *
     * @mbg.generated 2019-01-24
     */
    List<CartDo> selectByExample(CartDoExample example);

    /**
     *
     * @mbg.generated 2019-01-24
     */
    CartDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-01-24
     */
    int updateByExampleSelective(@Param("record") CartDo record, @Param("example") CartDoExample example);

    /**
     *
     * @mbg.generated 2019-01-24
     */
    int updateByExample(@Param("record") CartDo record, @Param("example") CartDoExample example);

    /**
     *
     * @mbg.generated 2019-01-24
     */
    int updateByPrimaryKeySelective(CartDo record);

    /**
     *
     * @mbg.generated 2019-01-24
     */
    int updateByPrimaryKey(CartDo record);
}