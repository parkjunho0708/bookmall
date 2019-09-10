package kr.co.itcen.bookmall.vo;

public class OrderVo {
	private Long ordernum;
	private Long usernum;
	private String orderaddress;
	private int orderprice;
	private String userid;

	public Long getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Long ordernum) {
		this.ordernum = ordernum;
	}

	public Long getUsernum() {
		return usernum;
	}

	public void setUsernum(Long usernum) {
		this.usernum = usernum;
	}

	public String getOrderaddress() {
		return orderaddress;
	}

	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}

	public int getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(int orderprice) {
		this.orderprice = orderprice;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "OrderVo [ordernum=" + ordernum + ", usernum=" + usernum + ", orderaddress=" + orderaddress
				+ ", orderprice=" + orderprice + ", userid=" + userid + "]";
	}

}
