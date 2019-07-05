package com.wishes.market.controller;

import com.wishes.market.model.CommodityDo;
import com.wishes.market.service.BusinessService;
import com.wishes.market.service.CommodityService;
import com.wishes.market.service.ConsoleService;
import com.wishes.market.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 控制台Controller
 *
 * @author 郑龙
 * @date 2019/2/26
 **/
@Slf4j
@ApiIgnore
@Controller
@RequestMapping("/console")
public class ConsoleController {
    @Autowired(required = false)
    private CommodityService commodityService;

    @Autowired(required = false)
    private ConsoleService consoleService;

    @Autowired
    private BusinessService businessService;


    /************
     * 页面相关  *
     ************/

    /**
     * 根据URL地址，自动跳转到相应的View页面中
     *
     * @param path 页面URL地址
     * @return
     */
    @RequestMapping("/views/{path}")
    public String jump(@PathVariable("path") String path) {
        //处理跳转的地址
        path = path.replaceAll("-", "/");
        return path;
    }

    /************
     * 业务相关  *
     ************/

    /**
     * 查询商品信息
     *
     * @return ResultUtil
     */
    @ResponseBody
    @RequestMapping("/queryCommodityType")
    public ResultUtil queryCommodityType() {
        try {
            return ResultUtil.success("商品类别查询成功！"
                    , commodityService.queryCommodityTypes());
        } catch (Exception e) {
            log.error("商品类别查询失败！", e);
        }
        return ResultUtil.fail("商品类别查询失败！");
    }

    /**
     * 添加一则商品数据
     *
     * @param commodity 商品信息
     * @return ResultUtil
     */
    @ResponseBody
    @PostMapping("/addCommodity")
    public ResultUtil addCommodity(CommodityDo commodity) {
        if (consoleService.addCommodity(commodity)) {
            return ResultUtil.success("商品添加成功！");
        }

        return ResultUtil.fail("商品添加失败！");
    }

    @ResponseBody
    @GetMapping("/listUser")
    public ResultUtil listUser() {
        return ResultUtil.success("拉取用户列表成功！", consoleService.listUser());
    }

    /**
     * 根据商品id查询商品详情
     *
     * @param CommodityId 商品id
     * @return 商品model
     */
    @ResponseBody
    @RequestMapping(value = "/queryCommodityInfoById", method = RequestMethod.GET)
    public CommodityDo queryCommodityInfoById(Long CommodityId) {
        return businessService.queryCommodityInfoById(CommodityId);
    }
}
