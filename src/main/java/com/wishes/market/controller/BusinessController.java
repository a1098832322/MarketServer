package com.wishes.market.controller;

import com.wishes.market.config.CommConfig;
import com.wishes.market.dto.CartDto;
import com.wishes.market.dto.CommodityQueryRequest;
import com.wishes.market.service.BusinessService;
import com.wishes.market.utils.PageDto;
import com.wishes.market.utils.ResultUtil;
import com.wishes.market.vo.CommodityTypeVo;
import com.wishes.market.vo.CommodityVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品相关操作Controller
 *
 * @author 郑龙
 * @date 2019-01-24  15:56
 */
@Slf4j
@RestController
@RequestMapping("/business")
@Api(tags = "业务相关接口")
public class BusinessController {
    @Autowired(required = false)
    private BusinessService businessService;

    /**
     * 分页查询
     *
     * @param request 基本请求体
     * @return 分页
     */
    @ApiOperation(httpMethod = "GET", value = "分页查询商品", notes = "分页查询商品接口",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityType", value = "商品类型id",
                    paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/queryPage", method = RequestMethod.GET)
    public PageDto<CommodityVo> queryCommodities(CommodityQueryRequest request) {
        return businessService.queryCommodities(request);
    }


    /**
     * 查询商品类别
     *
     * @return ResultUtil 商品类别json
     */
    @ApiOperation(httpMethod = "GET", value = "查询商品类型", notes = "查询商品类型接口",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @RequestMapping(value = "/queryCommodityTypes", method = RequestMethod.GET)
    public ResultUtil queryCommodityTypes() {
        List<CommodityTypeVo> voList = new ArrayList<>();

        try {
            businessService.queryCommodityTypes()
                    .forEach(commodityTypeDo -> {
                        CommodityTypeVo vo = new CommodityTypeVo();
                        BeanUtils.copyProperties(commodityTypeDo, vo);
                        voList.add(vo);
                    });
            return ResultUtil.success("查询成功！", voList);
        } catch (Exception e) {
            log.error("获取商品类别信息失败！", e);
        }

        return ResultUtil.fail("获取商品类别信息失败！");
    }

    /**
     * 根据商品id查询商品详情
     *
     * @param CommodityId 商品id
     * @return 商品model
     */
    @ApiOperation(httpMethod = "GET", value = "根据商品id查询商品详情", notes = "根据商品id查询商品详情",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "CommodityId", value = "商品id", paramType = "query",
                    dataType = "Long", required = true)
    })
    @RequestMapping(value = "/queryCommodityInfoById", method = RequestMethod.GET)
    public CommodityVo queryCommodityInfoById(Long CommodityId) {
        CommodityVo vo = new CommodityVo();
        BeanUtils.copyProperties(businessService.queryCommodityInfoById(CommodityId), vo);
        return vo;
    }

    /**
     * 根据商品名模糊查询商品信息
     *
     * @param CommodityName 商品名
     * @return 商品model list
     */
    @ApiOperation(httpMethod = "GET", value = "根据商品名模糊查询商品信息列表", notes = "根据商品名模糊查询商品信息列表",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "CommodityName", value = "商品名", paramType = "query",
                    dataType = "String", required = true)
    })
    @RequestMapping(value = "/queryCommodityInfoByName", method = RequestMethod.GET)
    public List<CommodityVo> queryCommodityInfoByName(String CommodityName) {
        return businessService.queryCommodityInfoByName(CommodityName);
    }

    /**
     * 添加进购物车
     *
     * @param uId     用户id
     * @param cIds    商品id们
     * @param numbers 购买数量们
     * @return 状态码
     * @throws IllegalArgumentException 参数不合法异常
     */
    @ApiOperation(httpMethod = "POST", value = "将商品添加进购物车", notes = "将商品添加进购物车",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public ResultUtil addToCart(Long uId, Long[] cIds, Integer[] numbers) throws IllegalArgumentException {
        for (int i = 0; i < cIds.length; i++) {
            CommConfig.CODES code = businessService
                    .addToCart(cIds[i], uId, numbers[i]);
            if (CommConfig.CODES.SUCCESS
                    .getCode().equals(code.getCode())) {
                continue;
            } else {
                return ResultUtil.success(code.getMessage());
            }
        }

        return ResultUtil.success(CommConfig.CODES.SUCCESS.getMessage());
    }

    /**
     * 刷新购物车数据
     *
     * @param uId     用户id
     * @param cIds    商品id们
     * @param numbers 购买数量们
     * @return 状态码
     * @throws IllegalArgumentException 参数不合法异常
     */
    @ApiOperation(httpMethod = "POST", value = "刷新购物车数据", notes = "刷新购物车数据",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @RequestMapping(value = "/refreshCart", method = RequestMethod.POST)
    public ResultUtil refreshCart(Long uId, Long[] cIds, Integer[] numbers) throws IllegalArgumentException {
        for (int i = 0; i < cIds.length; i++) {
            CommConfig.CODES code = businessService
                    .refreshCart(cIds[i], uId, numbers[i]);
            if (CommConfig.CODES.SUCCESS
                    .getCode().equals(code.getCode())) {
                continue;
            } else {
                return ResultUtil.success(code.getMessage());
            }
        }

        return ResultUtil.success(CommConfig.CODES.SUCCESS.getMessage());
    }

    /**
     * 购买
     *
     * @param uId     用户id
     * @param cIds    商品id们
     * @param numbers 购买数量们
     * @return 状态码
     * @throws IllegalArgumentException 参数不合法异常
     */
    @ApiOperation(httpMethod = "POST", value = "购买商品", notes = "购买商品",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public ResultUtil buy(Long uId,
                          Long[] cIds, Integer[] numbers) throws IllegalArgumentException {
        for (int i = 0; i < cIds.length; i++) {
            CommConfig.CODES code = businessService.buy(cIds[i], uId,
                    numbers[i]);
            if (CommConfig.CODES.SUCCESS.getCode().equals(code.getCode())) {
                continue;
            } else {
                return ResultUtil.success(code.getMessage());
            }
        }
        return ResultUtil.success(CommConfig.CODES.SUCCESS.getMessage());
    }

    /**
     * 查询用户购买历史l
     *
     * @param uId   用户id
     * @param limit 每页数据长度
     * @param page  当前页码
     * @return 分页数据
     */
    @ApiOperation(httpMethod = "GET", value = "查询用户购买历史", notes = "查询用户购买历史",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uId", value = "用户id", paramType = "query",
                    dataType = "Long", required = true),
            @ApiImplicitParam(name = "limit", value = "分页显示条数",
                    paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "page", value = "当前页面页码",
                    paramType = "query", dataType = "int", required = true)
    })
    @RequestMapping(value = "/queryBoughtList", method = RequestMethod.GET)
    public PageDto<CartDto> queryBoughtList(Long uId, int limit, int page) {
        return businessService.queryBoughtList(uId, limit, page);
    }

    /**
     * 查询用户购物车
     *
     * @param uId   用户id
     * @param limit 每页数据长度
     * @param page  当前页码
     * @return 分页数据
     */
    @ApiOperation(httpMethod = "GET", value = "查询购物车数据", notes = "查询购物车数据",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uId", value = "用户id", paramType = "query",
                    dataType = "Long", required = true),
            @ApiImplicitParam(name = "limit", value = "分页显示条数",
                    paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "page", value = "当前页面页码",
                    paramType = "query", dataType = "int", required = true)
    })
    @RequestMapping(value = "/queryCartList", method = RequestMethod.GET)
    public PageDto<CartDto> queryCartList(Long uId, int limit, int page) {
        return businessService.queryCartList(uId, limit, page);
    }


    /**
     * 从购物车中删除
     *
     * @param uId     用户id
     * @param cIds    商品id们
     * @param numbers 购买数量们
     * @return 状态码
     * @throws IllegalArgumentException 参数不合法异常
     */
    @ApiOperation(httpMethod = "POST", value = "从购物车中批量删除商品(也支持删除一件)", notes =
            "从购物车中批量删除商品(也支持删除一件)", response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @RequestMapping(value = "/deleteFromCart", method = RequestMethod.POST)
    public ResultUtil deleteFromCart(Long uId,
                                     Long[] cIds, Integer[] numbers) throws IllegalArgumentException {
        for (int i = 0; i < cIds.length; i++) {
            CommConfig.CODES code = businessService.deleteFromCart(cIds[i], uId,
                    numbers[i]);
            if (CommConfig.CODES.SUCCESS.getCode().equals(code.getCode())) {
                continue;
            } else {
                return ResultUtil.success(code.getMessage());
            }
        }
        return ResultUtil.success(CommConfig.CODES.SUCCESS.getMessage());
    }
}
