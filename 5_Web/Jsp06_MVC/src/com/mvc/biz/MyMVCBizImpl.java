package com.mvc.biz;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.mvc.dao.MyMVCDao;
import com.mvc.dao.MyMVCDaoImpl;
import com.mvc.dto.MyMVCDto;


public class MyMVCBizImpl implements MyMVCBiz{
	
	private MyMVCDao dao = new MyMVCDaoImpl();

	@Override
	public List<MyMVCDto> selectAll() {
		Connection con = getConnection(); // 커넥션만 여기서 진행 > 필요시 트랜잭션 작업까지 수행
		List<MyMVCDto> res= dao.selectAll(con); // dao 에게 일시켜 결과를 가져옴
		
		close(con); // 작업을 수행 후 커넥션을 닫음 
		System.out.println("db 종료");
		return res;
	}

	@Override
	public MyMVCDto selectOne(int seq) {
		Connection con = getConnection();
		
		MyMVCDto res=dao.selectOne(con, seq);
		close(con);
		System.out.println("db 종료");
		return res;
	}

	@Override
	public boolean insert(MyMVCDto dto) {
		Connection con = getConnection();
		boolean res=dao.insert(con, dto);
//		boolean res2=dao2.insert();
//		boolean res3=dao3.insert();
//		(res && res2 && res3)// 이와같은 경우를 biz클래스에서 관리 > res,res2,res3가 모두 true여야만 commit을 실행
		if(res) {  
			commit(con); // insert가 성공하면 commit을 실행 , 실패하면 rollback
		}else {
			rollback(con);
		}
		
		
		close(con);
		System.out.println("db 종료");
		return res;
	}

	@Override
	public boolean update(MyMVCDto dto) {
		Connection con = getConnection();
		
		boolean res=dao.update(con, dto); // connection 객체와 controller로 부터 받은 dto 객체를 넘겨준다
		
		if(res) {  
			commit(con);
		}else {
			rollback(con);
		}
		
		
		close(con);
		System.out.println("db 종료");
		return res;
	}

	@Override
	public boolean delete(int seq) {
		return false;
	}

}
