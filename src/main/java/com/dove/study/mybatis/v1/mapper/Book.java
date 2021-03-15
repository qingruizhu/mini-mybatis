package com.dove.study.mybatis.v1.mapper;

import java.io.Serializable;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2021/3/15 下午4:07
 */
public class Book implements Serializable {
    private Long id;

    //用户id
    private Long userId;

    //书名
    private String name;

    //书的简介
    private String bookDesc;

    //书主对书的介绍
    private String userDesc;

    //押金
    private Long price;

    //租赁价格
    private Long rentPrice;

    //状态：0-空闲；1-已租；9-下架
    private Integer status;

    //热度
    private Long star;

    //种类Id
    private Long categoryId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Long rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getStar() {
        return star;
    }

    public void setStar(Long star) {
        this.star = star;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", name=").append(name);
        sb.append(", bookDesc=").append(bookDesc);
        sb.append(", userDesc=").append(userDesc);
        sb.append(", price=").append(price);
        sb.append(", rentPrice=").append(rentPrice);
        sb.append(", status=").append(status);
        sb.append(", star=").append(star);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
