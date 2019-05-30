package com.wishes.market.service.impl;

import com.wishes.market.config.CommConfig;
import com.wishes.market.mapper.CommodityDoMapperExt;
import com.wishes.market.mapper.CommodityTypeDoMapperExt;
import com.wishes.market.model.CommodityDo;
import com.wishes.market.model.CommodityDoExample;
import com.wishes.market.model.CommodityTypeDo;
import com.wishes.market.model.CommodityTypeDoExample;
import com.wishes.market.service.CommodityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 商品相关service 实现类
 *
 * @author 郑龙
 * @date 2019-01-24  16:53
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class CommodityServiceImpl implements CommodityService {
    @Autowired(required = false)
    private CommodityDoMapperExt commodityDoMapperExt;

    @Autowired(required = false)
    private CommodityTypeDoMapperExt commodityTypeDoMapperExt;

    @Override
    public boolean isExistCommodity(Long cId) {
        return commodityDoMapperExt.selectByPrimaryKey(cId) != null;
    }

    @Override
    public boolean isExistCommodity(String cName) {
        CommodityDoExample example = new CommodityDoExample();
        CommodityDoExample.Criteria criteria = example.createCriteria();
        //构造查询条件
        criteria.andIsDeletedEqualTo(CommConfig.IS_DELETE.NO.getType());
        criteria.andCommodityNameLike("%" + cName + "%");
        List<CommodityDo> commodities =
                commodityDoMapperExt.selectByExample(example);

        return !CollectionUtils.isEmpty(commodities);
    }

    @Override
    public List<CommodityTypeDo> queryCommodityTypes() {
        CommodityTypeDoExample example = new CommodityTypeDoExample();
        CommodityTypeDoExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(CommConfig.IS_DELETE.NO.getType());
        //得到查询结果
        return commodityTypeDoMapperExt.selectByExample(example);
    }
}
