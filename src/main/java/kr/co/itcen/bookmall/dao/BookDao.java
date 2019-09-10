package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.BookVo;

public class BookDao {

	public boolean insert(BookVo vo) { // vo는 값을 담는 역할을 하는 것
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();

			String sql = "insert into book values (null, ?, ?, ?, ?, ?, ?, ?, ?)"; // jdbc는 ;(세미콜론)이 있으면 쿼리가 또 있다고 인식
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getBooktitle());
			pstmt.setString(2, vo.getBookwriter());
			pstmt.setString(3, vo.getBookcompany());
			pstmt.setString(4, vo.getBookrelease());
			pstmt.setInt(5, vo.getBookprice());
			pstmt.setInt(6, vo.getBookcount());
			pstmt.setLong(7,  vo.getCategorynum());
			pstmt.setString(8, vo.getCategoryname());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long booknum = rs.getLong(1);
				vo.setBooknum(booknum);
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

	public List<BookVo> select() {
		List<BookVo> result = new ArrayList<BookVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();
			
			String sql = "select book.booknum, book.booktitle, book.bookwriter, "
					+ "book.bookcompany, book.bookrelease, "
					+ "book.bookprice, book.bookcount, category.categorynum, category.categoryname from book, category "
					+ "where book.categorynum = category.categorynum "
					+ "group by book.booknum "
					+ "order by book.booknum";
			
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long booknum = rs.getLong(1);
				String booktitle = rs.getString(2);
				String bookwriter = rs.getString(3);
				String bookcompany = rs.getString(4);
				String bookrelease = rs.getString(5);
				int bookprice = rs.getInt(6);
				int bookcount = rs.getInt(7);
				Long categorynum = rs.getLong(8);
				String categoryname = rs.getString(9);
				
				BookVo vo = new BookVo();
				vo.setBooknum(booknum);
				vo.setBooktitle(booktitle);
				vo.setBookwriter(bookwriter);
				vo.setBookcompany(bookcompany);
				vo.setBookrelease(bookrelease);
				vo.setBookprice(bookprice);
				vo.setBookcount(bookcount);
				vo.setCategorynum(categorynum);
				vo.setCategoryname(categoryname);

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

//	public boolean update(UserVo vo) { // vo는 값을 담는 역할을 하는 것
//		Boolean result = false;
//		Connection connection = null;
//		PreparedStatement pstmt = null;
//		try {
//			connection = getConnection();
//
//			String sql = "update user set username = ?, userbirthday = ? where userid = ?"; // jdbc는 ;(세미콜론)이 있으면 쿼리가 또 있다고 인식
//			pstmt = connection.prepareStatement(sql);
//			pstmt.setString(1, vo.getUsername());
//			pstmt.setString(2, vo.getUserbirthday());
//			pstmt.setString(3, vo.getUserid());
//			
//			int count = pstmt.executeUpdate();
//			result = (count == 1);
//		} catch (SQLException e) {
//			System.out.println("error : " + e);
//		} finally {
//			try {
//				if (pstmt != null) {
//					pstmt.close();
//				}
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}


	public void delete() {
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			String sql = "delete from book";
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
