package com.wishes.market.config;

import lombok.Getter;

public class CommConfig {
    /**
     * 系统目录分隔符
     */
    public static final String SEPARATOR = System.getProperty("file.separator");
    /**
     * cookie存在客户端的key
     */
    public static final String MARKET_USER = "MARKET_USER";
    /**
     * cookie 生命周期
     */
    public static final int COOKIE_AGE = 8 * 60 * 60;
    /**
     * AES加密key
     */
    public static final String MARKET_KEY = "3c56602233254dd4be6db5d9b7f9a23a";

    /**
     * 最长用户名字符串长度
     */
    public static final int MAX_USERNAME_LENGTH = 12;

    /**
     * 最长密码长度
     */
    public static final int MAX_PASSWORD_LENGTH = 10;

    public enum IS_DELETE {
        YES("Y", "删除"),
        NO("N", "未删除");

        @Getter
        String type;
        @Getter
        String message;

        IS_DELETE(String type, String message) {
            this.type = type;
            this.message = message;
        }
    }

    public enum CODES {
        SUCCESS(1, "成功"),
        COMMODITY_SOLD_OUT(2, "目标商品已售空！"),
        COMMODITY_NOT_FOUND(3, "目标商品未查找到！"),
        COMMODITY_SURPLUS_INSUFFICIENT(4, "目标商品库存不足以完成本次交易！"),
        FAIL_OF_BAD_NETWORK(-1, "因为网络故障，请求失败！"),
        ILLEGAL_ARGUMENT(-2, "请求参数不合法！"),
        USER_NOT_FOUND(-3, "未查询到用户！"),
        FAIL_OF_UNKNOW_REASON(-4, "因为未知原因，请求失败！"),
        TARGET_NOT_FOUND(-5, "根据输入参数，未查找到数据！");


        @Getter
        Integer code;
        @Getter
        String message;

        CODES(Integer code, String message) {
            this.code = code;
            this.message = message;
        }
    }

}
