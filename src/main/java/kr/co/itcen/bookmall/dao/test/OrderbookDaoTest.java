package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.OrderbookDao;
import kr.co.itcen.bookmall.vo.OrderbookVo;

//-----------------------------------------
//		주문 도서 리스트
//-----------------------------------------
public class OrderbookDaoTest {

	public static void main(String[] args) {
		insertTest(); // create
		selectTest(); // read
	}

	public static void insertTest() {
		System.out.println("[주문 도서 리스트] insert test--------------------------------");
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

	private static void selectTest() {
		System.out.println("[주문 도서 리스트] select test--------------------------------");
		OrderbookDao dao = new OrderbookDao();

		List<OrderbookVo> list = dao.select();
		for (OrderbookVo vo : list) {
			System.out.println(vo);
		}
	}
}
