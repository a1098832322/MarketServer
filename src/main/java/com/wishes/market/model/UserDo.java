package com.wishes.market.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class UserDo {
    /**
     * 用户id
     */
    @ApiModelProperty(hidden = true)
    private Long id;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户昵称
     */
    @ApiModelProperty(hidden = true)
    private String uname;

    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private Date createTime;

    /**
     * 数据是否被删除
     */
    @ApiModelProperty(hidden = true)
    private String isDeleted;

    /**
     * 用户id
     *
     * @return id 用户id
     */
    public Long getId() {
        return id;
    }

    /**
     * 用户id
     *
     * @param id 用户id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户账号
     *
     * @return account 用户账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 用户账号
     *
     * @param account 用户账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 密码
     *
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 用户昵称
     *
     * @return uname 用户昵称
     */
    public String getUname() {
        return uname;
    }

    /**
     * 用户昵称
     *
     * @param uname 用户昵称
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * 创建时间
     *
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 数据是否被删除
     *
     * @return is_deleted 数据是否被删除
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 数据是否被删除
     *
     * @param isDeleted 数据是否被删除
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}