package kr.co.itcen.bookmall.vo;

public class CategoryVo {
	private Long categorynum; // 범주번호
	private String categoryname; // 범주이름

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
		return "CategoryVo [categorynum=" + categorynum + ", categoryname=" + categoryname + "]";
	}

}
