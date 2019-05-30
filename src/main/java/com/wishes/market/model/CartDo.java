package com.wishes.market.model;

public class CartDo {
    /**
     * 购物车-自增id
     */
    private Long id;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 商品id
     */
    private Integer cid;

    /**
     * 购买数量
     */
    private Integer number;

    /**
     * 总花费
     */
    private Double totalPrice;

    /**
     * 是否已经购买(0：否；1：是)[用这个字段也可以区分商品究竟是加入购物车还是已购买]
     */
    private Integer isPurchased;

    /**
     * 数据是否被删除
     */
    private String isDeleted;

    /**
     * 购物车-自增id
     * @return id 购物车-自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 购物车-自增id
     * @param id 购物车-自增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户id
     * @return uid 用户id
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 用户id
     * @param uid 用户id
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 商品id
     * @return cid 商品id
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * 商品id
     * @param cid 商品id
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * 购买数量
     * @return number 购买数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 购买数量
     * @param number 购买数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 总花费
     * @return total_price 总花费
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * 总花费
     * @param totalPrice 总花费
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 是否已经购买(0：否；1：是)[用这个字段也可以区分商品究竟是加入购物车还是已购买]
     * @return is_purchased 是否已经购买(0：否；1：是)[用这个字段也可以区分商品究竟是加入购物车还是已购买]
     */
    public Integer getIsPurchased() {
        return isPurchased;
    }

    /**
     * 是否已经购买(0：否；1：是)[用这个字段也可以区分商品究竟是加入购物车还是已购买]
     * @param isPurchased 是否已经购买(0：否；1：是)[用这个字段也可以区分商品究竟是加入购物车还是已购买]
     */
    public void setIsPurchased(Integer isPurchased) {
        this.isPurchased = isPurchased;
    }

    /**
     * 数据是否被删除
     * @return is_deleted 数据是否被删除
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 数据是否被删除
     * @param isDeleted 数据是否被删除
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}