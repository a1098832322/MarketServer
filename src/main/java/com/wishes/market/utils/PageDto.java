package com.wishes.market.utils;

import lombok.Data;

import java.util.List;

/**
 * 分页对象
 *
 * @author huangt
 * @create 2018-01-18 10:00
 **/
@Data
public class PageDto<T> {

    private int currentPage;
    private int pageSize;
    private int total;
    private int offset;
    private List<T> lists;

    public PageDto() {
    }
    
    public PageDto(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        //计算偏移量
        if (currentPage == 1) {
            this.offset = 0;
        } else {
            this.offset = (currentPage - 1) * pageSize;
        }
    }
    
    public PageDto(int currentPage, int pageSize, int total) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
        //计算偏移量
        if (currentPage == 1) {
            this.offset = 0;
        } else {
            this.offset = (currentPage - 1) * pageSize;
        }
    }

    public PageDto(int currentPage, int pageSize, int total, List<T> lists) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
        //计算偏移量
        if (currentPage == 1) {
            this.offset = 0;
        } else {
            this.offset = (currentPage - 1) * pageSize;
        }
        this.lists = lists;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }
}
