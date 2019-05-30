package com.wishes.market.model;

public class CommodityTypeDo {
    /**
     * 商品类别自增id
     */
    private Long id;

    /**
     * 商品类别解释
     */
    private String name;

    /**
     * 图标地址
     */
    private String iconPath;

    /**
     * 是否删除数据
     */
    private String isDeleted;

    /**
     * 商品类别自增id
     * @return id 商品类别自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 商品类别自增id
     * @param id 商品类别自增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 商品类别解释
     * @return name 商品类别解释
     */
    public String getName() {
        return name;
    }

    /**
     * 商品类别解释
     * @param name 商品类别解释
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 图标地址
     * @return icon_path 图标地址
     */
    public String getIconPath() {
        return iconPath;
    }

    /**
     * 图标地址
     * @param iconPath 图标地址
     */
    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    /**
     * 是否删除数据
     * @return is_deleted 是否删除数据
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除数据
     * @param isDeleted 是否删除数据
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}