package kr.co.itcen.bookmall.vo;

public class CategoryVo {
	private Long categorynum;
	private String categoryname;

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
