package com.xll.util;

import java.text.ParseException;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * 查询辅助
 * @author Administrator
 *
 */
@Component("queryUtil")
public abstract class queryUtil {
	private final int DEFAULT_PAGESIZE=5;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	protected Date starttime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	protected Date endtime;
	protected int page=1;
	protected int pageSize=DEFAULT_PAGESIZE;
	protected int startIndex=0;
	protected String orderBy;
	public Date getStarttime() throws ParseException {
		if(starttime==null){
			String now=SelfDateFormat.dateToString(new Date());
			starttime=SelfDateFormat.stringToDate(now.substring(0,now.lastIndexOf("-")).concat("-01"));
		}
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartIndex() {
		this.startIndex=(page-1)*pageSize;
		return startIndex;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	

	

}
