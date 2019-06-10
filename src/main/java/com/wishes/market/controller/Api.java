package com.wishes.market.controller;

import com.wishes.market.model.UserDo;
import com.wishes.market.service.UserService;
import com.wishes.market.utils.ParameterExecutor;
import com.wishes.market.utils.ResultUtil;
import com.zl.utils.ValidateUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口Api
 *
 * @author 郑龙
 * @date 2019/6/10 10:20
 */
@Slf4j
@RestController
@RequestMapping("/api")
@io.swagger.annotations.Api(tags = "外部服务接口")
public class Api {
    @Autowired
    private UserService userService;

    /**
     * 提供给外部，判断登录状态
     *
     * @param account  账号
     * @param password 密码
     * @return true/false 成功/失败
     */
    @ApiOperation(httpMethod = "GET", value = "分页查询商品", notes = "分页查询商品接口",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号",
                    required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码",
                    required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping("/login")
    public ResultUtil login(String account, String password) {
        //校验参数
        ValidateUtil.validateParams(ParameterExecutor.createExecutor(), account, password);
        UserDo userDo = new UserDo();
        userDo.setAccount(account);
        userDo.setPassword(password);
        return userService.login(userDo) != null
                ? ResultUtil.success()
                : ResultUtil.fail();
    }
}
