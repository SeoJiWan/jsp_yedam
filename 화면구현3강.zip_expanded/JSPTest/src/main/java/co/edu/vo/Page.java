package co.edu.vo;

public class Page {
	/*
	 * Field
	 */
	private int startPage; // 첫 번째 - ex) 전체 150페이지중 <-(11~20)-> 씩 보여주기
	private int endPage; // 마지막
	private boolean prev; // 이전페이지 있는지 체크
	private boolean next; // 다음페이지 있는지 체크
	private int total; // 전체건수
	private Criteria cri;
	private int showPage = 10;
	
	/*
	 * Constructor
	 */
	public Page(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		// end page 계산
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * showPage;
		// start page 계산
		this.startPage = this.endPage - showPage + 1;
		int realEnd = (int) (Math.ceil(total * 1.0 / cri.getAmount()));
		
		if (this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}


	/*
	 * Method
	 */
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public int getShowPage() {
		return showPage;
	}

	public void setShowPage(int showPage) {
		this.showPage = showPage;
	}

	

}
