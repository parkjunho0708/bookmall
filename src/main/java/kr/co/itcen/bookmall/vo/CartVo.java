package kr.co.itcen.bookmall.vo;

public class CartVo {
	private Long cartnum; // primary key 카트번호
	private Long usernum; // 고객번호
	private Long booknum; // 도서번호
	private String userid; // 고객아이디
	private String booktitle; // 도서제목

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
