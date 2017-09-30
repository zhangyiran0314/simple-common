package com.chenyee.common.utils;

/**
 * @author Ma Guohui
 * @FileDescription:分页信息类，用来描述分页信息
 * @version 2013-03-06 下午2:55:03
 * @ChangeList:
 */
public class Page {
	/**
	 * 每页显示多少条数据
	 */
	public static int pageSize = 10;
	/**
	 * 每页显示记录数
	 */
	private int everyPage;
	/**
	 * 总记录数
	 */
	private int totalCount;
	/**
	 * 总页数
	 * 
	 */
	private int totalPage;
	/**
	 * 当前页
	 */
	private int currentPage;
	/**
	 * 查询起始点
	 */
	private int beginIndex;
	/**
	 * 是否有上一页
	 */
	private boolean hasPrePage;
	/**
	 * 是否有下一页
	 */
	private boolean hasNextPage;
	/**
	 * 自定义构造方法
	 */
	public Page(int everyPage, int totalCount, int totalPage, int currentPage,
			int beginIndex, boolean hasPrePage, boolean hasNextPage) {
		this.everyPage = everyPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.beginIndex = beginIndex;
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
	}
	/**
	 * 默认构造函数
	 * 
	 */
	public Page() {
	}
	/**
	 * 获得每页显示记录数
	 * 
	 */
	public int getEveryPage() {
		return everyPage;
	}
	/**
	 * 设置每页显示记录数
	 * 
	 */
	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}
	/**
	 * 获得总记录数
	 * 
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * 设置总记录数
	 * 
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * 获得总页数
	 * 
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * 设置总页数
	 * 
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * 获得当前页
	 * 
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * 设置当前页
	 * 
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * 获得查询起始点
	 * 
	 */
	public int getBeginIndex() {
		return beginIndex;
	}
	/**
	 * 设置查询起始点
	 * 
	 */
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	/**
	 * 获得是否有上一页
	 * 
	 */
	public boolean getHasPrePage() {
		return hasPrePage;
	}
	/**
	 * 设置是否有上一页
	 * 
	 */
	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}
	/**
	 * 获得是否有下一页
	 * 
	 */
	public boolean getHasNextPage() {
		return hasNextPage;
	}
	/**
	 *设置是否有下一页
	 * 
	 */
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	
	
	
}
