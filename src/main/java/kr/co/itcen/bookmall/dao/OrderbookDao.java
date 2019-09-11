package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.OrderbookVo;

public class OrderbookDao {

	public boolean insert(OrderbookVo vo) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();

			String sql = "insert into orderbook values (null, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, vo.getBooknum());
			pstmt.setLong(2, vo.getOrdernum());
			pstmt.setString(3, vo.getBooktitle());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long orderbooknum = rs.getLong(1);
				vo.setOrderbooknum(orderbooknum);
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
	
	public List<OrderbookVo> select() {
		List<OrderbookVo> result = new ArrayList<OrderbookVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();
			
			String sql = "select "
					+ "orderbook.orderbooknum, "
					+ "book.booknum, "
					+ "book.booktitle, "
					+ "bookmall.order.ordernum "
					+ "from orderbook, book, bookmall.order "
					+ "where orderbook.booknum = book.booknum "
					+ "and orderbook.ordernum = bookmall.order.ordernum "
					+ "and orderbook.booktitle = book.booktitle "
					+ "order by orderbook.orderbooknum";
			
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long orderbooknum = rs.getLong(1);
				Long booknum = rs.getLong(2);
				String booktitle = rs.getString(3);
				Long ordernum = rs.getLong(4);
				
				OrderbookVo vo = new OrderbookVo();
				vo.setOrderbooknum(orderbooknum);
				vo.setBooknum(booknum);
				vo.setOrdernum(ordernum);
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
			String sql = "delete from orderbook";
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
