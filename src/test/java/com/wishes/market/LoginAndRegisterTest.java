package com.wishes.market;

import com.alibaba.fastjson.JSON;
import com.wishes.market.controller.UserController;
import com.wishes.market.model.UserDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 登录和注册测试
 *
 * @author 郑龙
 * @date 2019/3/19 16:43
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginAndRegisterTest {
    @Autowired
    private UserController userController;

    /**
     * 假账号，该账号数据库中不存在
     */
    private static final String FAKE_ACCOUNT = "qwer";

    /**
     * 真账号，该账号数据库中存在
     */
    private static final String TRUE_ACCOUNT = "user1";

    /**
     * 假密码，该密码错误
     */
    private static final String FAKE_PASSWORD = "1234556667";

    /**
     * 正确的密码
     */
    private static final String TRUE_PASSWORD = "123";

    @Test
    public void test() {
        UserDo user = new UserDo();
        user.setAccount(TRUE_ACCOUNT);
        user.setPassword(FAKE_PASSWORD);

        System.out.println(JSON.toJSONString(userController.login(user)));

    }
}
