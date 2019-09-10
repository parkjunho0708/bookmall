package kr.co.itcen.bookmall.dao.test;

import java.util.List;
import java.util.Scanner;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.UserVo;

//-----------------------------------------
//		회원 리스트
//-----------------------------------------
public class UserDaoTest {

	public static void main(String[] args) {
		insertTest();// create
		selectTest(); // read
		updateTest(); // update
		//deleteAllTest(); // delete
	}

	public static void insertTest() {
		System.out.println("[회원 리스트] insert test--------------------------------");
		UserDao dao = new UserDao();
		UserVo vo1 = new UserVo();

		vo1.setUserid("user1");
		vo1.setUserpasswd("123123");
		vo1.setUsername("장동건");
		vo1.setUserbirthday("1972년 3월 7일");
		vo1.setUsergender("남성");
		vo1.setUseraddress("부산광역시 부산진구 중앙대로 933");
		vo1.setUserphonenum("010-2343-4535");
		vo1.setUseremail("itcen345@gmail.com");
		dao.insert(vo1);
		System.out.println(vo1);
		
		UserVo vo2 = new UserVo();

		vo2.setUserid("user2");
		vo2.setUserpasswd("321321");
		vo2.setUsername("조인성");
		vo2.setUserbirthday("1981년 7월 28일");
		vo2.setUsergender("남성");
		vo2.setUseraddress("부산광역시 부산진구 동천로 92 NC백화점 서면점 1층");
		vo2.setUserphonenum("010-9584-5943");
		vo2.setUseremail("itcen987@gmail.com");
		dao.insert(vo2);
		System.out.println(vo2);
	}

	private static void selectTest() {
		System.out.println("[회원 리스트] select test--------------------------------");
		UserDao dao = new UserDao();

		List<UserVo> list = dao.select();
		for (UserVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void updateTest() {
		System.out.println("[회원 리스트] update test--------------------------------");
		UserDao dao = new UserDao();
		
		UserVo vo1 = new UserVo();
		vo1.setUserid("user1");
		vo1.setUsername("원빈");
		vo1.setUserbirthday("1982년 5월 13일");
		dao.update(vo1);
		
		UserVo vo2 = new UserVo();
		vo2.setUserid("user2");
		vo2.setUsername("강동원");
		vo2.setUserbirthday("1983년 9월 15일");
		dao.update(vo2);
		
		List<UserVo> list = dao.select();
		for (UserVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void deleteAllTest() {
		System.out.println("delete All test--------------------------------");
		new UserDao().delete();
		
		UserDao dao = new UserDao();
		
		List<UserVo> list = dao.select();
		for (UserVo vo : list) {
			System.out.println(vo);
		}
	}
}
