package com.wishes.market.service.impl;

import com.wishes.market.config.CommConfig;
import com.wishes.market.config.StringConstant;
import com.wishes.market.mapper.UserDoMapperExt;
import com.wishes.market.model.UserDo;
import com.wishes.market.model.UserDoExample;
import com.wishes.market.service.UserService;
import com.wishes.market.utils.security.AESTool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户Service实现类
 *
 * @author 郑龙
 * @date 2019-01-24  11:54
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserDoMapperExt userDoMapperExt;

    @Override
    public String login(UserDo user) {
        String account = user.getAccount();
        String password = user.getPassword();

        if (StringUtils.isBlank(account)
                || StringUtils.isBlank(password)) {
            return null;
        } else {
            //构造查询条件
            UserDoExample example = new UserDoExample();
            UserDoExample.Criteria criteria = example.createCriteria();
            //查询数据库
            criteria.andAccountEqualTo(account);
            criteria.andIsDeletedEqualTo(CommConfig.IS_DELETE.NO.getType());
            List<UserDo> userInDb = userDoMapperExt.selectByExample(example);
            if (!CollectionUtils.isEmpty(userInDb)) {
                String passInDb = userInDb.get(0).getPassword();
                Long uid = userInDb.get(0).getId();
                String userName = userInDb.get(0).getUname();

                //AES加密输入密码，并校对
                try {
                    String encryptPwdStr = AESTool.encrypt(password,
                            CommConfig.MARKET_KEY);
                    if (passInDb.equals(encryptPwdStr)) {
                        // TODO: 2019/1/24 可能要做一些持久化鉴权操作
                        // 先不做了算了！
                        return uid + "," + StringConstant.LOGIN_SUCCESS + "," + userName;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("登陆失败！" + e);
                }

            }
        }

        return null;
    }

    @Override
    public String register(UserDo user) {
        String account = user.getAccount();
        String password = user.getPassword();
        String userName = user.getUname();

        //获取用户昵称
        if (StringUtils.isBlank(userName)) {
            user.setUname("新注册用户" + System.currentTimeMillis());
        }

        if (StringUtils.isBlank(account)
                || StringUtils.isBlank(password)) {
            return null;
        } else {
            //构造查询条件
            UserDoExample example = new UserDoExample();
            UserDoExample.Criteria criteria = example.createCriteria();
            //查询数据库
            criteria.andAccountEqualTo(account);
            criteria.andIsDeletedEqualTo(CommConfig.IS_DELETE.NO.getType());
            List<UserDo> userInDb = userDoMapperExt.selectByExample(example);
            if (!CollectionUtils.isEmpty(userInDb)) {
                return StringConstant.REGISTER_FAIL_REASON_DUPLICATE_ACCOUNT;
            } else {
                //将密码进行加密
                try {
                    password = AESTool.encrypt(password, CommConfig.MARKET_KEY);
                    user.setPassword(password);
                    //存入数据库
                    userDoMapperExt.insertSelective(user);
                    return StringConstant.REGISTER_SUCCESS;
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("注册失败！" + e);
                }
            }
        }

        return null;
    }

    /**
     * 修改密码、昵称等用户数据
     *
     * @param user 用户信息
     * @return true/false 成功/失败
     */
    @Override
    public boolean modifyUserInfo(UserDo user) {
        return userDoMapperExt.updateByPrimaryKeySelective(user) > 0;
    }

    @Override
    public UserDo getUserInfoByUid(Long uId) {
        return userDoMapperExt.selectByPrimaryKey(uId);
    }

    @Override
    public void logout(Integer uid) {

    }

    @Override
    public boolean isExistUser(Long uid) {
        return userDoMapperExt.selectByPrimaryKey(uid) != null;
    }

    @Override
    public boolean isExistUser(String account) {
        if (StringUtils.isBlank(account)) {
            return false;
        }

        UserDoExample example = new UserDoExample();
        UserDoExample.Criteria criteria = example.createCriteria();
        //构造查询条件
        criteria.andAccountEqualTo(account);
        criteria.andIsDeletedEqualTo(CommConfig.IS_DELETE.NO.getType());

        List<UserDo> user = userDoMapperExt.selectByExample(example);

        return !CollectionUtils.isEmpty(user);
    }
}
