package com.wishes.market.mapper;

import com.wishes.market.model.CommodityDo;
import com.wishes.market.model.CommodityDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityDoMapper {
    /**
     *
     * @mbg.generated 2019-04-01
     */
    long countByExample(CommodityDoExample example);

    /**
     *
     * @mbg.generated 2019-04-01
     */
    int deleteByPrimaryKey(CommodityDo record);

    /**
     *
     * @mbg.generated 2019-04-01
     */
    int insert(CommodityDo record);

    /**
     *
     * @mbg.generated 2019-04-01
     */
    int insertSelective(CommodityDo record);

    /**
     *
     * @mbg.generated 2019-04-01
     */
    List<CommodityDo> selectByExampleWithBLOBs(CommodityDoExample example);

    /**
     *
     * @mbg.generated 2019-04-01
     */
    List<CommodityDo> selectByExample(CommodityDoExample example);

    /**
     *
     * @mbg.generated 2019-04-01
     */
    CommodityDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-04-01
     */
    int updateByExampleSelective(@Param("record") CommodityDo record, @Param("example") CommodityDoExample example);

    /**
     *
     * @mbg.generated 2019-04-01
     */
    int updateByExampleWithBLOBs(@Param("record") CommodityDo record, @Param("example") CommodityDoExample example);

    /**
     *
     * @mbg.generated 2019-04-01
     */
    int updateByExample(@Param("record") CommodityDo record, @Param("example") CommodityDoExample example);

    /**
     *
     * @mbg.generated 2019-04-01
     */
    int updateByPrimaryKeySelective(CommodityDo record);

    /**
     *
     * @mbg.generated 2019-04-01
     */
    int updateByPrimaryKeyWithBLOBs(CommodityDo record);

    /**
     *
     * @mbg.generated 2019-04-01
     */
    int updateByPrimaryKey(CommodityDo record);
}