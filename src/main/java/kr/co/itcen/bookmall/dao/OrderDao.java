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
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDao {
	
	public boolean insert(OrderVo vo) {
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();

			String sql = "insert into bookmall.order values (null, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, vo.getUsernum());
			pstmt.setString(2, vo.getOrderaddress());
			pstmt.setInt(3, vo.getOrderprice());
			pstmt.setString(4, vo.getUserid());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select last_insert_id()");
			if(rs.next()) {
				Long ordernum = rs.getLong(1);
				vo.setOrdernum(ordernum);
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

	public List<OrderVo> select() {
		List<OrderVo> result = new ArrayList<OrderVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = getConnection();
			
			String sql = "select "
					+ "bookmall.order.ordernum, "
					+ "user.usernum, "
					+ "bookmall.order.orderaddress, "
					+ "bookmall.order.orderprice, "
					+ "user.userid "
					+ "from bookmall.order, user "
					+ "where user.usernum = bookmall.order.usernum "
					+ "and user.userid = bookmall.order.userid "
					+ "group by bookmall.order.ordernum "
					+ "order by bookmall.order.ordernum";
			
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long ordernum = rs.getLong(1);
				Long usernum = rs.getLong(2);
				String orderaddress = rs.getString(3);
				int orderprice = rs.getInt(4);
				String userid = rs.getString(5);
				
				OrderVo vo = new OrderVo();
				vo.setOrdernum(ordernum);
				vo.setUsernum(usernum);
				vo.setOrderaddress(orderaddress);
				vo.setOrderprice(orderprice);
				vo.setUserid(userid);

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
