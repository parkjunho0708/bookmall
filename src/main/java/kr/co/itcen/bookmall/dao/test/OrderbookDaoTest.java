package kr.co.itcen.bookmall.dao.test;

import kr.co.itcen.bookmall.dao.OrderbookDao;
import kr.co.itcen.bookmall.vo.OrderbookVo;

public class OrderbookDaoTest {
	
	public static void main(String[] args) {
		insertTest(); // create
//		selectTest(); // read
//		updateTest(); // update
//		deleteAllTest(); // delete
	}

	public static void insertTest() {
		System.out.println("insert test--------------------------------");
		OrderbookDao dao = new OrderbookDao();
		
		OrderbookVo orderbookVo1 = new OrderbookVo();
		orderbookVo1.setBooknum(1L);
		orderbookVo1.setOrdernum(1L);
		orderbookVo1.setBooktitle("리액트를 다루는 기술");
		dao.insert(orderbookVo1);
		System.out.println(orderbookVo1);
		
		OrderbookVo orderbookVo2 = new OrderbookVo();
		orderbookVo2.setBooknum(2L);
		orderbookVo2.setOrdernum(1L);
		orderbookVo2.setBooktitle("우리 나무 이름 사전");
		dao.insert(orderbookVo2);
		System.out.println(orderbookVo2);
	}

//	private static void selectTest() {
//		System.out.println("select test--------------------------------");
//		OrderbookDao dao = new OrderbookDao();
//
//		List<OrderbookVo> list = dao.select();
//		for (OrderbookVo vo : list) {
//			System.out.println(vo);
//		}
//	}

//	private static void updateTest() {
//		// TODO Auto-generated method stub
//
//	}
//
//	private static void deleteAllTest() {
//		new OrderbookDao().delete();
//	}
}
