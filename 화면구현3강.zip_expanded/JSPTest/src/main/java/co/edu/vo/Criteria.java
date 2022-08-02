package co.edu.vo;

public class Criteria {
	/*
	 * Field
	 */
	private int pageNum;
	private int amount;

	/*
	 * Constructor
	 */
	public Criteria() {
		this.pageNum = 1;
		this.amount = 10;
	}
	
	/*
	 * Method
	 */
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	

}
