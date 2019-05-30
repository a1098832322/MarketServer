package com.wishes.market.service;

import com.wishes.market.model.UserDo;

/**
 * 用户登录、登出、注册Service
 *
 * @author 郑龙
 * @date 2019-01-24  11:49
 */
public interface UserService {
    /**
     * 用户登录
     *
     * @param user 用户信息
     * @return String/null 成功/失败
     */
    String login(UserDo user);

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return String/null 成功/失败
     */
    String register(UserDo user);

    /**
     * 修改密码、昵称等用户数据
     *
     * @param user 用户信息
     * @return true/false 成功/失败
     */
    boolean modifyUserInfo(UserDo user);


    /**
     * 根据用户id查询用户信息
     *
     * @param uId 用户id
     * @return 用户信息实体
     */
    UserDo getUserInfoByUid(Long uId);

    /**
     * 用户登出
     *
     * @param uid 用户id
     */
    void logout(Integer uid);

    /**
     * 是否存在用户
     *
     * @param uid 用户id
     * @return 是否存在用户
     */
    boolean isExistUser(Long uid);

    /**
     * 是否存在用户
     *
     * @param account 用户账户
     * @return 是否存在用户
     */
    boolean isExistUser(String account);
}
