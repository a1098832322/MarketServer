package com.wishes.market.utils;

import java.io.Serializable;

/**
 * @Auther: zhongyu
 * @Date: 2018/6/11 16:22
 * @Description:定义返回数据统一封装的类
 */
public class ResultUtil implements Serializable {
    private static final long serialVersionUID = -6397502849111787708L;

    /**
     * 成功
     */
    private static final Boolean TRUE = true;

    /**
     * 失败
     */
    private static final Boolean FALSE = false;

    /**
     * 返回成功码
     */
    private static final int SUCCESS_CODE = 0;

    /**
     * 返回失败码
     */
    private static final int FAIL_CODE = -1;

    /**
     * 成功/失败 状态
     */
    private boolean flag;

    /**
     * 编码 0：成功 非0：失败
     */
    private int code;

    /**
     * 信息
     */
    private String message;

    /**
     * 返回的数据
     */
    private Object data;

    public ResultUtil() {
    }

    /**
     * 请求成功时返回的对象
     */
    public static ResultUtil success(String message, Object data) {
        ResultUtil result = new ResultUtil();
        result.setFlag(TRUE);
        result.setCode(SUCCESS_CODE);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 请求成功时返回的对象
     */
    public static ResultUtil success(Object data) {
        if (data instanceof String) {
            return success((String) data);
        } else {
            ResultUtil result = new ResultUtil();
            result.setFlag(TRUE);
            result.setCode(SUCCESS_CODE);
            result.setData(data);
            return result;
        }
    }

    /**
     * 请求成功时返回的对象
     */
    public static ResultUtil success(String message) {
        ResultUtil result = new ResultUtil();
        result.setFlag(TRUE);
        result.setCode(SUCCESS_CODE);
        result.setMessage(message);
        return result;
    }

    /**
     * 请求成功时返回的对象
     */
    public static ResultUtil success() {
        ResultUtil result = new ResultUtil();
        result.setFlag(TRUE);
        result.setCode(SUCCESS_CODE);
        result.setData(null);
        return result;
    }

    /**
     * 请求失败时返回的对象
     */
    public static ResultUtil fail(int code, String message) {
        ResultUtil result = new ResultUtil();
        result.setFlag(FALSE);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 请求失败时返回的对象
     */
    public static ResultUtil fail(String message) {
        ResultUtil result = new ResultUtil();
        result.setFlag(FALSE);
        result.setCode(FAIL_CODE);
        result.setMessage(message);
        return result;
    }

    /**
     * 请求失败时返回的对象
     */
    public static ResultUtil fail() {
        ResultUtil result = new ResultUtil();
        result.setFlag(FALSE);
        result.setCode(FAIL_CODE);
        return result;
    }

    public static Boolean getTRUE() {
        return TRUE;
    }

    public static Boolean getFALSE() {
        return FALSE;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
