package com.wishes.market.mapper;

import com.wishes.market.model.CommodityTypeDo;
import com.wishes.market.model.CommodityTypeDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityTypeDoMapper {
    /**
     *
     * @mbg.generated 2019-03-21
     */
    long countByExample(CommodityTypeDoExample example);

    /**
     *
     * @mbg.generated 2019-03-21
     */
    int deleteByPrimaryKey(CommodityTypeDo record);

    /**
     *
     * @mbg.generated 2019-03-21
     */
    int insert(CommodityTypeDo record);

    /**
     *
     * @mbg.generated 2019-03-21
     */
    int insertSelective(CommodityTypeDo record);

    /**
     *
     * @mbg.generated 2019-03-21
     */
    List<CommodityTypeDo> selectByExample(CommodityTypeDoExample example);

    /**
     *
     * @mbg.generated 2019-03-21
     */
    CommodityTypeDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-03-21
     */
    int updateByExampleSelective(@Param("record") CommodityTypeDo record, @Param("example") CommodityTypeDoExample example);

    /**
     *
     * @mbg.generated 2019-03-21
     */
    int updateByExample(@Param("record") CommodityTypeDo record, @Param("example") CommodityTypeDoExample example);

    /**
     *
     * @mbg.generated 2019-03-21
     */
    int updateByPrimaryKeySelective(CommodityTypeDo record);

    /**
     *
     * @mbg.generated 2019-03-21
     */
    int updateByPrimaryKey(CommodityTypeDo record);
}