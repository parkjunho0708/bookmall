package kr.co.itcen.bookmall.vo;

public class OrderbookVo {
	private Long orderbooknum;
	private Long booknum;
	private int orderbookcount;
	private Long ordernum;

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

	public int getOrderbookcount() {
		return orderbookcount;
	}

	public void setOrderbookcount(int orderbookcount) {
		this.orderbookcount = orderbookcount;
	}

	public Long getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Long ordernum) {
		this.ordernum = ordernum;
	}

	@Override
	public String toString() {
		return "OrderbookVo [orderbooknum=" + orderbooknum + ", booknum=" + booknum + ", orderbookcount="
				+ orderbookcount + ", ordernum=" + ordernum + "]";
	}

}
