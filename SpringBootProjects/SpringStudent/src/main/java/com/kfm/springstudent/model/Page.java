package com.kfm.springstudent.model;

import java.util.List;

public class Page<T> {

    /**
     * 此页存储的所有数据的 List
     */
    private List<T> dataList;




    /**
     * 一页的行数
     */
    private int pageRows;

    /**
     * 表中行数总计
     */
    private long totalRows;

    /**
     * 表中页数总计
     */
    private int totalPages;

    /**
     * 当前页页码
     */
    private int currentPageNum;

    /**
     * 上一页的页码
     */
    private int prevNum;

    /**
     * 下一页页码
     */
    private int nextNum;


}
