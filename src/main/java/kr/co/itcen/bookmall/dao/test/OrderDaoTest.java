package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;

//-----------------------------------------
//		주문 리스트
//-----------------------------------------
public class OrderDaoTest {
	
	public static void main(String[] args) {
		insertTest(); // create
		selectTest(); // read
		//deleteTest(); // delete
	}

	public static void insertTest() {
		System.out.println("[주문 리스트] insert test--------------------------------");
		System.out.println("***************** user1 order list *****************");
		OrderDao orderDao = new OrderDao();
		OrderVo orderVo = new OrderVo();
		int orderprice = 37800 + 17820; // user1이 주문한 책의 가격 합
		
		orderVo.setUsernum(1L);
		orderVo.setOrderaddress("서울특별시 서초구 신반포로 176"); // 배송지 주소
		orderVo.setOrderprice(orderprice); // user1이 주문한 책의 가격 합
		orderVo.setUserid("user1");
		orderDao.insert(orderVo);
		System.out.println(orderVo);
	}

	private static void selectTest() {
		System.out.println("[주문 리스트] select test--------------------------------");
		OrderDao dao = new OrderDao();

		List<OrderVo> list = dao.select();
		for (OrderVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void deleteTest() {
		new OrderDao().delete();
	}
}
