package kr.co.itcen.bookmall.vo;

public class OrderVo {
	private Long ordernum; // primary key 주문번호
	private Long usernum; // 고객번호
	private String orderaddress; // 배송지주소
	private int orderprice; // 결제금액
	private String userid; // 고객아이디

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
