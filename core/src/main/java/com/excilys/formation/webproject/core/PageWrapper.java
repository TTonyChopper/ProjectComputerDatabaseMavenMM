package com.excilys.formation.webproject.core;

import java.util.List;

/**
 * 
 * @author excilys
 *
 */
public class PageWrapper{

	/*****************************Builder*****************************/
	/**
	 * 
	 * @author excilys
	 *
	 */
	public static class PwBuilder {
		private String nameFilter;
		private Integer pageNumber;
		private String fieldOrder;
		private String order;
		private String orderNumber;
		private List<Computer> computerList;
		private Integer computerListSize;

		/**
		 * 
		 * @param nameFilter
		 * @return
		 */
		public PwBuilder nameFilter(String nameFilter) {
			this.nameFilter = nameFilter;
			return this;
		}
		/**
		 * 
		 * @param pagenumber
		 * @return
		 */
		public PwBuilder pageNumber(Integer pageNumber) {
			this.pageNumber = pageNumber;
			return this;
		}
		/**
		 * 
		 * @param fieldOrder
		 * @return
		 */
		public PwBuilder fieldOrder(String fieldOrder) {
			this.fieldOrder = fieldOrder;
			return this;
		}
		/**
		 * 
		 * @param order
		 * @return
		 */
		public PwBuilder order(String order) {
			this.order = order;
			return this;
		}
		/**
		 * 
		 * @param orderNumber
		 * @return
		 */
		public PwBuilder orderNumber(String orderNumber) {
			this.orderNumber = orderNumber;
			return this;
		}
		/**
		 * 
		 * @param computerlist
		 * @return
		 */
		public PwBuilder computerList(List<Computer> computerList) {
			this.computerList = computerList;
			return this;
		}
		/**
		 * 
		 * @param computerlistsize
		 * @return
		 */
		public PwBuilder computerListSize(Integer computerListSize) {
			this.computerListSize = computerListSize;
			return this;
		}
		/**
		 * 
		 * @return
		 */
		public PageWrapper build() {
			return new PageWrapper(this);
		}
	}
	/*****************************Builder*****************************/

	/**
	 * 
	 * @return
	 */
	public static PwBuilder builder() {
		return new PwBuilder();
	}
	public PageWrapper() {
	}
	/**
	 * 
	 * @param builder
	 */
	private PageWrapper(PwBuilder builder) {
		this.nameFilter = builder.nameFilter;
		this.pageNumber = builder.pageNumber;
		this.fieldOrder = builder.fieldOrder;
		this.order = builder.order;
		this.orderNumber = builder.orderNumber;
		this.computerList = builder.computerList;
		this.computerListSize = builder.computerListSize;
	}	

	//Attributs
	private String nameFilter;
	private Integer pageNumber;
	private String fieldOrder;
	private String order;
	private String orderNumber;
	private List<Computer> computerList;
	private Integer computerListSize;
	private final static int PAGE_INCREMENT[]={-20,-10,-5,-4,-3,-2,-1,0,1,2,3,4,5,10,20};
	private final static int PER_PAGE = 25;

	//Auto-generations		
	public int[] getPageIncrement() {
		return PAGE_INCREMENT;
	}
	public int getPerPage() {
		return PER_PAGE;
	}
	public String getNameFilter() {
		return nameFilter;
	}
	public void setNameFilter(String nameFilter) {
		this.nameFilter = nameFilter;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getFieldOrder() {
		return fieldOrder;
	}
	public void setFieldOrder(String fieldOrder) {
		this.fieldOrder = fieldOrder;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public List<Computer> getComputerList() {
		return computerList;
	}
	public void setComputerList(List<Computer> computerList){
		this.computerList = computerList;
	}
	public Integer getComputerListSize() {
		return computerListSize;
	}
	public void setComputerListSize(Integer computerListSize) {
		this.computerListSize = computerListSize;
	}

}