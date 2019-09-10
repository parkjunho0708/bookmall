package kr.co.itcen.bookmall.vo;

public class UserVo {
	private Long usernum;
	private String userid;
	private String userpasswd;
	private String username;
	private String userbirthday;
	private String usergender;
	private String useraddress;
	private String userphonenum;
	private String useremail;

	public Long getUsernum() {
		return usernum;
	}

	public void setUsernum(Long usernum) {
		this.usernum = usernum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpasswd() {
		return userpasswd;
	}

	public void setUserpasswd(String userpasswd) {
		this.userpasswd = userpasswd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserbirthday() {
		return userbirthday;
	}

	public void setUserbirthday(String userbirthday) {
		this.userbirthday = userbirthday;
	}

	public String getUsergender() {
		return usergender;
	}

	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getUserphonenum() {
		return userphonenum;
	}

	public void setUserphonenum(String userphonenum) {
		this.userphonenum = userphonenum;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	@Override
	public String toString() {
		return "UserVo [usernum=" + usernum + ", userid=" + userid + ", userpasswd=" + userpasswd + ", username="
				+ username + ", userbirthday=" + userbirthday + ", usergender=" + usergender + ", useraddress="
				+ useraddress + ", userphonenum=" + userphonenum + ", useremail=" + useremail + "]";
	}

}
