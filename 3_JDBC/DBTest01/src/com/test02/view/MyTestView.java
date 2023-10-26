package com.test02.view;

import java.util.List;
import java.util.Scanner;

import com.test02.dao.MyTestDao;
import com.test02.dto.MyTest;
import static common.JDBCTemplate.*;

public class MyTestView {
	public static int getMenu() {
		int select = 0;
		System.out.println("1. 전체 출력");
		System.out.println("2. 추가");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 종료");

		
		System.out.println("번호 선택:");
		select = new Scanner(System.in).nextInt();

		return select;
	}

	public static void main(String[] args) {
		int no = 0;
		int mno = 0;

		String mname = null;
		String nickname = null;

		Scanner sc = new Scanner(System.in);
		MyTestDao dao = new MyTestDao();

		do {
			no = getMenu();
			switch (no) {

			case 1:
//				전체 출력 select
				List<MyTest> selectRes=dao.selectAll();
				System.out.println("--- 전체 출력 --- ");
				for(MyTest tmp:selectRes) {
					System.out.println(tmp);
				}
				break;
			case 2:
//				추가 insert
				
//				번호추가 함수 삭제 : 디비버에서 INSERT 할때  SQL - AUTO_INCREMENT 를 사용하여 NULL 값을 기입하여도 번호가 작성되는걸 확인했기때문에 따로 작성하지 않음 
				System.out.println("추가할 이름 : ");
				mname=sc.next();
				System.out.println("추가할 별명 : ");
				nickname = sc.next();
				
				MyTest dto = new MyTest(0,mname,nickname);
				
				int insertRes = dao.insert(dto);
				if(insertRes>0) {
					System.out.println("입력 성공");
				}else {
					System.out.println("입력 실패");
				}
				break;
			case 3:
//				수정 update
				System.out.println("수정할 사람 번호 :");
				mno=sc.nextInt();
				System.out.println("수정할 이름 : ");
				mname=sc.next();
				System.out.println("수정할 별명 : ");
				nickname = sc.next();
				
				MyTest update=new MyTest(mno,mname,nickname); // 업데이트 할 항목들을 받아 객체에 저장
				int updateRes=dao.update(update); // 객체를 update 메소드에 변수로 넘겨줌
				
				if(updateRes>0) {
					System.out.println("수정 성공");
				}else {
					System.out.println("수정 실패"); // 실패이유 : 해당 리스트안에 조회환 번호가 없기때문
				}
				break;
			case 4:
//				삭제 delete
				System.out.println("삭제할 번호:");
				mno=sc.nextInt();
				dao.delete(mno);
				
				int deleteRes = dao.delete(mno);
				if(deleteRes>0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 성공");
				}
			case 5:
//				종료
				System.out.println("프로그램 종료");
				break;

			}
		} while (no != 5);
	}
}
