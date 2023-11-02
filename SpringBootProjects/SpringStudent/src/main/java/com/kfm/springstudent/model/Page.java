package com.kfm.springstudent.model;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {

    /**
     * 此页存储的所有数据的 List
     */
    private List<T> onePageDataList;

    /**
     * 所有页码
     */
    private Integer[] pageNumbers;

    /**
     * 一页的行数
     */
    private int onePageRow;

    /**
     * 表中行数总计
     */
    private long totalRowsCount;

    /**
     * 表中页数总计
     */
    private int totalPagesCount;

    /**
     * 当前页页码
     */
    private int currentPageNumber;

    /**
     * 上一页的页码
     */
    private int prevPageNumber;

    /**
     * 下一页页码
     */
    private int nextPageNumber;

    /**
     * 是否有下一页
     */
    private boolean hasNextPage;

    /**
     * 是否有上一页
     */
    private boolean hasPervPage;

    public Page(
            List<T> onePageDataList,
            int currentPageNumber,
            int onePageRow,
            long totalRowsCount
    ) {
        this.onePageDataList = onePageDataList;
        this.currentPageNumber = currentPageNumber;
        this.onePageRow = onePageRow;
        this.totalRowsCount = totalRowsCount;
    }

    /**
     * 总行数 除以 一页的行数 向上取整
     *
     * @return 总页数
     */
    public int getTotalPagesCount() {
        return (int) Math.ceil((double) totalRowsCount / onePageRow);
    }

    /**
     * 当前页是否不等于总页数
     *
     * @return ture-有下一页    false-没有下一页
     */
    public boolean getHasNextPage() {
        return currentPageNumber != getTotalPagesCount();
    }

    /**
     * 当前页是否不等于 1
     *
     * @return true-有上一页    false-没有上一页
     */
    public boolean getHasPervPage() {
        return currentPageNumber != 1;
    }

    /**
     * 获取下一页
     *
     * @return 当前页 + 1
     */
    public int getNextPageNumber() {
        return currentPageNumber + 1;
    }

    /**
     * 获取页码数组 页码数为当前页的前两个和后两个
     *
     * @return 返回页码数组，页码数字根据最大行数变化，最多五个
     */
    public int[] getPageNumbers() {
        //定义两个指针，限定数组长度为 5
        int start = 1;
        int end = getTotalPagesCount();
        //如果页数总计大于五
        if (getTotalPagesCount() > 5) {
            // 则设定头指针为当前页码 -2
            start = currentPageNumber - 2;
            if (start <= 0) {
                start = 1;
            }
            //尾指针为当前页码 +2
            end = currentPageNumber + 2;
            if (end >= getTotalPagesCount()) {
                end = getPrevPageNumber();
            }
        }
        //定义一个事实上返回的数组，长度最大为 5
        int[] actualReturnArray = new int[end - start + 1];
        //给数组中的值根据头指针赋值
        for (int i = 0; i < actualReturnArray.length; i++) {
            actualReturnArray[i] = start + i;
        }
        return actualReturnArray;
    }


    /**
     * 获取上一页
     *
     * @return 当前页 - 1
     */
    public int getPrevPageNumber() {
        return currentPageNumber - 1;
    }
}
