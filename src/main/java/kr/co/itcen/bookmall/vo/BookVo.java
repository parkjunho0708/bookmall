package kr.co.itcen.bookmall.vo;

public class BookVo {
	private Long booknum;
	private String booktitle;
	private String bookwriter;
	private String bookcompany;
	private String bookrelease;
	private int bookprice;
	private int bookcount;
	private Long categorynum;
	private String categoryname;

	public Long getBooknum() {
		return booknum;
	}

	public void setBooknum(Long booknum) {
		this.booknum = booknum;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getBookwriter() {
		return bookwriter;
	}

	public void setBookwriter(String bookwriter) {
		this.bookwriter = bookwriter;
	}

	public String getBookcompany() {
		return bookcompany;
	}

	public void setBookcompany(String bookcompany) {
		this.bookcompany = bookcompany;
	}

	public String getBookrelease() {
		return bookrelease;
	}

	public void setBookrelease(String bookrelease) {
		this.bookrelease = bookrelease;
	}

	public int getBookprice() {
		return bookprice;
	}

	public void setBookprice(int bookprice) {
		this.bookprice = bookprice;
	}

	public int getBookcount() {
		return bookcount;
	}

	public void setBookcount(int bookcount) {
		this.bookcount = bookcount;
	}

	public Long getCategorynum() {
		return categorynum;
	}

	public void setCategorynum(Long categorynum) {
		this.categorynum = categorynum;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	@Override
	public String toString() {
		return "BookVo [booknum=" + booknum + ", booktitle=" + booktitle + ", bookwriter=" + bookwriter
				+ ", bookcompany=" + bookcompany + ", bookrelease=" + bookrelease + ", bookprice=" + bookprice
				+ ", bookcount=" + bookcount + ", categorynum=" + categorynum + ", categoryname=" + categoryname + "]";
	}

}
