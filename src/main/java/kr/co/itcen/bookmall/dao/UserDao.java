package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.UserVo;

public class UserDao {

	public boolean insert(UserVo vo) { // vo는 값을 담는 역할을 하는 것
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();

			String sql = "insert into user values (null, ?, ?, ?, ?, ?, ?, ?, ?)"; // jdbc는 ;(세미콜론)이 있으면 쿼리가 또 있다고 인식
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpasswd());
			pstmt.setString(3, vo.getUsername());
			pstmt.setString(4, vo.getUserbirthday());
			pstmt.setString(5, vo.getUsergender());
			pstmt.setString(6, vo.getUseraddress());
			pstmt.setString(7, vo.getUserphonenum());
			pstmt.setString(8, vo.getUseremail());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long usernum = rs.getLong(1);
				vo.setUsernum(usernum);
			}
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<UserVo> select() {
		List<UserVo> result = new ArrayList<UserVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			String sql = "select usernum, userid, userpasswd, username, userbirthday, usergender, "
					+ "useraddress, userphonenum, useremail from user order by usernum";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long usernum = rs.getLong(1);
				String userid = rs.getString(2);
				String userpasswd = rs.getString(3);
				String username = rs.getString(4);
				String userbirthday = rs.getString(5);
				String usergender = rs.getString(6);
				String useraddress = rs.getString(7);
				String userphonenum = rs.getString(8);
				String useremail = rs.getString(9);
				
				
				UserVo vo = new UserVo();
				vo.setUsernum(usernum);
				vo.setUserid(userid);
				vo.setUserpasswd(userpasswd);
				vo.setUsername(username);
				vo.setUserbirthday(userbirthday);
				vo.setUsergender(usergender);
				vo.setUseraddress(useraddress);
				vo.setUserphonenum(userphonenum);
				vo.setUseremail(useremail);

				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean update(UserVo vo) { // vo는 값을 담는 역할을 하는 것
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = getConnection();

			String sql = "update user set username = ?, userbirthday = ? where userid = ?"; // jdbc는 ;(세미콜론)이 있으면 쿼리가 또 있다고 인식
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getUsername());
			pstmt.setString(2, vo.getUserbirthday());
			pstmt.setString(3, vo.getUserid());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}


	public void delete() {
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			String sql = "delete from user";
			pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private Connection getConnection() throws SQLException {
		Connection connection = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.93:3306/bookmall?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver : " + e);
		}

		return connection;
	}

}
