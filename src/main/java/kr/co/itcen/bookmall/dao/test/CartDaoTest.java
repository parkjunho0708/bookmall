package kr.co.itcen.bookmall.dao.test;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.CartVo;
import kr.co.itcen.bookmall.vo.UserVo;

public class CartDaoTest {
	
	public static void main(String[] args) {
		insertTest(); // create
		selectTest(); // read
		//updateTest(); // update
		//deleteAllTest(); // delete
	}

	public static void insertTest() {
		System.out.println("insert test--------------------------------");
		CartDao dao = new CartDao();
		UserVo userVo1 = new UserVo();
		CartVo cartVo1 = new CartVo();
		userVo1.setUsernum(userVo1.getUsernum());
		
//		vo1.setName("아이유");
//		dao.insert(vo1);
//		System.out.println(vo1);
//
//		UserVo vo2 = new UserVo();
//		vo2.setName("BTS");
//		dao.insert(vo2);
//		System.out.println(vo2);
//
//		UserVo vo3 = new UserVo();
//		vo3.setName("소녀시대");
//		dao.insert(vo3);
//		System.out.println(vo3);
	}

	private static void selectTest() {
		System.out.println("select test--------------------------------");
		//UserDao dao = new UserDao();

		//List<UserVo> list = dao.getList();
		for (UserVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void updateTest() {
		// TODO Auto-generated method stub

	}

	private static void deleteAllTest() {
		//new UserDao().delete();
	}
}
