package cn.bdqn.flight.util;
/**
 * 分页工具
 * @author DELL
 *
 * @param <T>
 */

import java.util.ArrayList;
import java.util.List;

public class PageTool<T> {
	private Integer pageIndex;
	private Integer pageSize;
	private Integer dataCount;
	private Integer pageCount;
	private List<T> data_list=new ArrayList<T>();
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getDataCount() {
		return dataCount;
	}
	public void setDataCount(Integer dataCount) {
		this.dataCount = dataCount;
		this.pageCount=this.dataCount%this.pageSize==0?(this.dataCount/this.pageSize):(this.dataCount/this.pageSize+1);
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getData_list() {
		return data_list;
	}
	public void setData_list(List<T> data_list) {
		this.data_list = data_list;
	}
	
	
}
