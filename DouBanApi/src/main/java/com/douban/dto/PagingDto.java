package com.douban.dto;

import java.util.List;

/**
 * 分页查询数据封装类
 */
public class PagingDto<T> {

    private Long total;      // 数据记录总数
    private List<T> rows;     // 对应页面的记录
    private double totalSize; // 总页数
    private double pageIndex; // 当前页码
    private long pageSize;    // 每页记录数

    public PagingDto() {
    }

    public PagingDto(Long total, List<T> rows, double totalSize, double pageIndex, long pageSize) {
        this.total = total;
        this.rows = rows;
        this.totalSize = totalSize;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public double getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(double totalSize) {
        this.totalSize = totalSize;
    }

    public double getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(double pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }
}
