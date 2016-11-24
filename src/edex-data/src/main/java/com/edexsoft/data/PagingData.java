package com.edexsoft.data;

import java.util.List;

public class PagingData<T> {
	private Long pageSize;
	private Long pageIndex;
	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	public Long getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}
	public List<T> getEntities() {
		return Entities;
	}
	public void setEntities(List<T> entities) {
		Entities = entities;
	}
	public Long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	private List<T> Entities;
	private Long totalRecords;
}
