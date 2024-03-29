package kr.co.itcen.bookmall.vo;

public class OrderbookVo {
	private Long orderbooknum; // 주문도서번호
	private Long booknum; // 도서번호
	private Long ordernum; // 주문번호
	private String booktitle; // 도서제목

	public Long getOrderbooknum() {
		return orderbooknum;
	}

	public void setOrderbooknum(Long orderbooknum) {
		this.orderbooknum = orderbooknum;
	}

	public Long getBooknum() {
		return booknum;
	}

	public void setBooknum(Long booknum) {
		this.booknum = booknum;
	}

	public Long getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Long ordernum) {
		this.ordernum = ordernum;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	@Override
	public String toString() {
		return "OrderbookVo [orderbooknum=" + orderbooknum + ", booknum=" + booknum + ", ordernum=" + ordernum
				+ ", booktitle=" + booktitle + "]";
	}

}
