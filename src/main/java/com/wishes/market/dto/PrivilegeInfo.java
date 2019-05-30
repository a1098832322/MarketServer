package com.wishes.market.dto;

import java.util.Set;

import lombok.Data;

/**
 * 登录用户
 *
 * @author huangt
 * @create 2018-02-01 17:48
 **/
@Data
public class PrivilegeInfo {
    private Long userId;
    private String account;

    private String name;//登录人姓名
    private String realName;//登录人姓名(拿coockie的时候放实体里用)

    private String ip;//登录人ip
    private String roleIds;//登录人的角色ids
    //所拥有的角色编码
    private Set<String> roleCodes;
    //身份证号码
    private String idCard;

    //归属机构编码
    private String orgcode;
    /**
     * 归属机构别名 从该机构延伸的所有子机构 eg. 42%：湖北地区   4202%：黄石地区  4203%：十堰地区
     */
    private String likeOrgCode;
    //机构编码
    private Set<String> orgCodes;
}
