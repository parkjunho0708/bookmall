package kr.co.itcen.bookmall.vo;

public class CartVo {
	private Long cartnum;
	private Long usernum;
	private Long booknum;
	private String userid;
	private String booktitle;

	public Long getCartnum() {
		return cartnum;
	}

	public void setCartnum(Long cartnum) {
		this.cartnum = cartnum;
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

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	@Override
	public String toString() {
		return "CartVo [cartnum=" + cartnum + ", usernum=" + usernum + ", booknum=" + booknum + ", userid=" + userid
				+ ", booktitle=" + booktitle + "]";
	}

}
