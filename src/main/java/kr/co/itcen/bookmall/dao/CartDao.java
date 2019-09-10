package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CartVo;

public class CartDao {

	public boolean insert(CartVo vo) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();

			String sql = "insert into cart values (null, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, vo.getUsernum());
			pstmt.setLong(2, vo.getBooknum());
			pstmt.setString(3, vo.getUserid());
			pstmt.setString(4, vo.getBooktitle());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long cartnum = rs.getLong(1);
				vo.setCartnum(cartnum);
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

	public List<CartVo> select() {
		List<CartVo> result = new ArrayList<CartVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();
			
			String sql = "select "
					+ "cart.cartnum, "
					+ "user.usernum, "
					+ "user.userid, "
					+ "book.booknum, "
					+ "book.booktitle "
					+ "from cart, user, book "
					+ "where user.usernum = cart.usernum "
					+ "and user.userid = cart.userid "
					+ "and book.booknum = cart.booknum "
					+ "and book.booktitle = cart.booktitle "
					+ "group by cart.cartnum "
					+ "order by cart.cartnum";
			
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long cartnum = rs.getLong(1);
				Long usernum = rs.getLong(2);
				String userid = rs.getString(3);
				Long booknum = rs.getLong(4);
				String booktitle = rs.getString(5);
				
				CartVo vo = new CartVo();
				vo.setCartnum(cartnum);
				vo.setUsernum(usernum);
				vo.setUserid(userid);
				vo.setBooknum(booknum);
				vo.setBooktitle(booktitle);

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
	
	public void delete() {
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			String sql = "delete from cart";
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
