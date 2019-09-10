package kr.co.itcen.bookmall.vo;

public class BookVo {
	private Long booknum; // primary key 도서번호
	private String booktitle; // 도서제목
	private String bookwriter; // 도서저자
	private String bookcompany; // 도서출판사
	private String bookrelease; // 도서출판일
	private int bookprice; // 도서가격
	private Long categorynum; // 범주번호
	private String categoryname; // 범주이름

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
				+ ", categorynum=" + categorynum + ", categoryname=" + categoryname + "]";
	}

}
