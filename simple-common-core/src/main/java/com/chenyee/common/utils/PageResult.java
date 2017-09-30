package com.chenyee.common.utils;

import java.util.List;
/**
 * @author Ma Guohui
 * @FileDescription:分页查询结果信息，用来存储分页查询结果
 * @version 2013-03-06 下午2:55:03
 * @ChangeList:
 */
public class PageResult {
	/**
	 * 分页信息
	 */
	private Page page;	
	/**
	 * 查询记录信息
	 */
	private List list;		
	public PageResult(Page page, List list) {
		this.page = page;
		this.list = list;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
