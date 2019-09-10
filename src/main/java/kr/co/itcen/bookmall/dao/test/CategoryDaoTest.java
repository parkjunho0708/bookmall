package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.CategoryVo;

//-----------------------------------------
//		카테고리 리스트
//-----------------------------------------
public class CategoryDaoTest {
	
	public static void main(String[] args) {
		insertTest();// create
		selectTest(); // read
		//deleteTest(); // delete
	}

	public static void insertTest() {
		System.out.println("[카테고리 리스트] insert test--------------------------------");
		CategoryDao dao = new CategoryDao();
		
		CategoryVo vo1 = new CategoryVo();
		vo1.setCategoryname("프로그래밍");
		dao.insert(vo1);
		System.out.println(vo1);
		
		CategoryVo vo2 = new CategoryVo();
		vo2.setCategoryname("자연과학");
		dao.insert(vo2);
		System.out.println(vo2);
		
		CategoryVo vo3 = new CategoryVo();
		vo3.setCategoryname("역사");
		dao.insert(vo3);
		System.out.println(vo3);
	}

	private static void selectTest() {
		System.out.println("[카테고리 리스트] select test--------------------------------");
		CategoryDao dao = new CategoryDao();

		List<CategoryVo> list = dao.select();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void deleteTest() {
		new CategoryDao().delete();
	}
}
