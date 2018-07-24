package com.server.core.request;

public class VZyPage {
	
	private int pageIndex;

    private int pageSize;

    private int current;

    private long totalCount;

    public VZyPage() {
    }

    public VZyPage(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.current = (this.pageIndex - 1) * this.pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        this.current = (this.pageIndex - 1) * this.pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.current = (this.pageIndex - 1) * this.pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrent() {
        return current;
    }
}
