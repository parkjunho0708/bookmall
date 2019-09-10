package kr.co.itcen.bookmall.vo;

public class CartVo {
	private Long cartnum;
	private String cartbookname;
	private Long usernum;
	private Long booknum;
	private String userid;

	public Long getCartnum() {
		return cartnum;
	}

	public void setCartnum(Long cartnum) {
		this.cartnum = cartnum;
	}

	public String getCartbookname() {
		return cartbookname;
	}

	public void setCartbookname(String cartbookname) {
		this.cartbookname = cartbookname;
	}

	public Long getUsernum() {
		return usernum;
	}

	public void setUsernum(Long usernum) {
		this.usernum = usernum;
	}

	public Long getBooknum() {
		return booknum;
	}

	public void setBooknum(Long booknum) {
		this.booknum = booknum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "CartVo [cartnum=" + cartnum + ", cartbookname=" + cartbookname + ", usernum=" + usernum + ", booknum="
				+ booknum + ", userid=" + userid + "]";
	}

}
