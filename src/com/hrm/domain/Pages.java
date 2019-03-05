package com.hrm.domain;

public class Pages {
	int pageNow;
	int pageSize;
	int totalPage;//总页面数
	int totalSize;//总长度数
	boolean hasPre;
	boolean hasNext;

	public Pages(int pageNow, int pageSize, int totalSize) {
		super();
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		int totalPage=totalSize/pageSize;
		if(totalSize % pageSize>0)
			totalPage++;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public boolean isHasPre() {
		if(pageNow==1)
			return false;
		else
			return true;
	}
	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}
	public boolean isHasNext() {
		if(pageNow==this.getTotalPage())
			return false;
		else
			return true;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
}
