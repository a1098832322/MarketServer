package com.wishes.market.controller;

import com.wishes.market.config.CommConfig;
import com.wishes.market.model.UserDo;
import com.wishes.market.service.UserService;
import com.wishes.market.utils.ResultUtil;
import com.wishes.market.utils.security.AESTool;
import com.wishes.market.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录、登出、注册用Controller
 *
 * @author 郑龙
 * @date 2019-01-24  13:44
 */
@Slf4j
@RestController
@RequestMapping("/control")
@Api(tags = "登录登出及注册接口")
public class UserController {
    @Autowired(required = false)
    private UserService userService;

    /**
     * 登录
     *
     * @param user 实体对象
     * @return
     */
    @ApiOperation(value = "登录", notes = "登录接口",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号",
                    required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码",
                    required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultUtil login(UserDo user) {
        String result = userService.login(user);
        if (StringUtils.isBlank(result)) {
            return ResultUtil.fail("登陆失败");
        } else {
            String[] results = result.split(",");
            return ResultUtil.success(results[1],
                    results[0] + "," + results[2]);
        }


    }

    /**
     * 注册
     *
     * @param user 实体对象
     * @return
     */
    @ApiOperation(value = "注册", notes = "注册接口",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号",
                    required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码",
                    required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "uname", value = "用户昵称",
                    paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultUtil register(UserDo user) {
        String msg = userService.register(user);
        return msg != null ? ResultUtil.success(msg) :
                ResultUtil.fail("注册失败");
    }

    /**
     * 根据用户id查询用户信息
     *
     * @param uId 用户id
     * @return 用户信息实体
     */
    @ApiOperation(value = "根据用户id查询用户信息", notes = "根据用户id查询用户信息接口",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uId", value = "用户id",
                    required = true, paramType = "query", dataType = "Long")
    })
    @RequestMapping(value = "/getUserInfoByUid", method = RequestMethod.GET)
    public ResultUtil getUserInfoByUid(Long uId) {
        if (uId == null || uId < 0) {
            throw new IllegalArgumentException("输入的用户id不合法！");
        }
        UserDo userInfo = userService.getUserInfoByUid(uId);

        if (userInfo != null) {
            UserVo vo = new UserVo();
            BeanUtils.copyProperties(userInfo, vo);
            return ResultUtil.success("查询用户信息成功！", vo);
        } else {
            return ResultUtil.fail("根据用户id查询用户信息失败！");
        }
    }

    /**
     * 根据用户id修改用户昵称
     *
     * @param uId      用户id
     * @param userName 用户昵称
     * @return 结果result
     */
    @ApiOperation(value = "根据用户id修改用户昵称与密码", notes = "根据用户id修改用户昵称",
            response = ResultUtil.class, responseContainer = "Map", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uId", value = "用户id",
                    required = true, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "userName", value = "用户昵称", required =
                    true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required =
                    true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/changeUserInfo", method = RequestMethod.POST)
    public ResultUtil changeUserInfo(Long uId, String userName,
                                     String password) {
        //数据合法性判断
        if (uId == null || uId < 0) {
            return ResultUtil.fail("uId不合法！");
        }

        if (userName.length() > CommConfig.MAX_USERNAME_LENGTH) {
            return ResultUtil.fail("用户名不合法！用户名过长！");
        }

        if (password.length() > CommConfig.MAX_PASSWORD_LENGTH) {
            return ResultUtil.fail("密码长度过长！");
        }

        //将数据添加进实体
        UserDo user = new UserDo();
        user.setId(uId);
        if (StringUtils.isNotBlank(userName)) {
            user.setUname(userName);
        }

        if (StringUtils.isNotBlank(password)) {
            //使用AES加密密码
            try {
                password = AESTool.encrypt(password, CommConfig.MARKET_KEY);
                user.setPassword(password);
            } catch (Exception e) {
                log.error("使用AES加密密码失败！", e);
                return ResultUtil.fail("修改失败");
            }

        }

        return userService.modifyUserInfo(user) ?
                ResultUtil.success("修改成功！") :
                ResultUtil.fail("修改失败！");
    }

}
