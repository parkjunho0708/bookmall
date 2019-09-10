package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;

//-----------------------------------------
//		카트 리스트
//-----------------------------------------
public class CartDaoTest {
	
	public static void main(String[] args) {
		insertTest(); // create
		selectTest(); // read
		//deleteTest(); // delete
	}

	public static void insertTest() {
		String loginUser = "user1";
		System.out.println("[카트 리스트] insert test--------------------------------");
		if(loginUser.equals("user1")) {
			System.out.println("user1 login successful");
			System.out.println("도서구매시작----------------------------");
			CartDao dao = new CartDao();
			
			CartVo cartVo1 = new CartVo();
			cartVo1.setUsernum(1L);
			cartVo1.setBooknum(1L);
			cartVo1.setUserid(loginUser);
			cartVo1.setBooktitle("리액트를 다루는 기술");
			dao.insert(cartVo1);
			System.out.println(cartVo1);
			
			CartVo cartVo2 = new CartVo();
			cartVo2.setUsernum(1L);
			cartVo2.setBooknum(2L);
			cartVo2.setUserid(loginUser);
			cartVo2.setBooktitle("우리 나무 이름 사전");
			dao.insert(cartVo2);
			System.out.println(cartVo2);
		}
	}

	private static void selectTest() {
		System.out.println("[카트 리스트] select test--------------------------------");
		CartDao dao = new CartDao();

		List<CartVo> list = dao.select();
		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void deleteTest() {
		new CartDao().delete();
	}
}
