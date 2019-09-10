package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.BookVo;

//-----------------------------------------
//		상품 리스트
//-----------------------------------------
public class BookDaoTest {

	public static void main(String[] args) {
		insertTest(); // create
		selectTest(); // read
		//deleteTest();  // delete
	}

	public static void insertTest() {
		System.out.println("[상품 리스트] insert test--------------------------------");
		BookDao dao = new BookDao();
		
		BookVo vo1 = new BookVo();
		vo1.setBooktitle("리액트를 다루는 기술");
		vo1.setBookwriter("김민준");
		vo1.setBookcompany("길벗출판사");
		vo1.setBookrelease("2019년 08월 31일");
		vo1.setBookprice(37800);
		vo1.setCategorynum(1L);
		vo1.setCategoryname("프로그래밍");
		dao.insert(vo1);
		System.out.println(vo1);
		
		BookVo vo2 = new BookVo();
		vo2.setBooktitle("우리 나무 이름 사전");
		vo2.setBookwriter("박상진");
		vo2.setBookcompany("눌와");
		vo2.setBookrelease("2019년 08월 26일");
		vo2.setBookprice(17820);
		vo2.setCategorynum(2L);
		vo2.setCategoryname("자연과학");
		dao.insert(vo2);
		System.out.println(vo2);
		
		BookVo vo3 = new BookVo();
		vo3.setBooktitle("역사의 쓸모");
		vo3.setBookwriter("최태성");
		vo3.setBookcompany("다산초당");
		vo3.setBookrelease("2019년 06월 14일");
		vo3.setBookprice(13500);
		vo3.setCategorynum(3L);
		vo3.setCategoryname("역사");
		dao.insert(vo3);
		System.out.println(vo3);
	}

	private static void selectTest() {
		System.out.println("[상품 리스트] select test--------------------------------");
		BookDao dao = new BookDao();

		List<BookVo> list = dao.select();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void deleteTest() {
		new BookDao().delete();
	}
}
