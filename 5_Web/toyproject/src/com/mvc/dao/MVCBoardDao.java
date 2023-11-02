package com.mvc.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MVCBoardDto;
public class MVCBoardDao {
	// 전체 리스트 조회
	public List<MVCBoardDto> selectAll(){
		// 준비
		Connection con = getConnection(); // 연결
		Statement stm=null; // 메소드를 실행할 때 할당
		ResultSet rs=null; // 결과값
		
		List<MVCBoardDto> res= new ArrayList<>(); // 최종값을 저장할 리스트
		
		String sql = "SELECT * FROM MVCBOARDTWO ODER BY SEQ DESC";
		
		try {
			stm=con.createStatement(); // statement 객체 생성
			System.out.println("쿼리 준비:"+ sql);
			
			rs=stm.executeQuery(sql); // sql문으로 테이블값을 가져와 객체 stm에 저장
			
			while(rs.next()) {
				MVCBoardDto tmp=new MVCBoardDto(); // Dto 생성자를 이용해 객체 생성
				
				// 가져온 객체의 row순서에 맞게 값을 가져와서 저장한다
				tmp.setSeq(rs.getInt(1));
				tmp.setWriter(rs.getString(2));
				tmp.setTitle(rs.getString(3));
				tmp.setContent(rs.getString(4));
				tmp.setRegdate(rs.getDate(5));
				
				res.add(tmp); // 리스트에 tmp 객체의 값을 저장
				// next() 함수로인해 더이상 읽을 값이 없을때 까지 > 반복 
			}
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러 : 값을 가져오지 못함");
			e.printStackTrace();
		} finally {
//			서버 자원 소모를 제한하기위해 사용이 끝난 함수들은 연결을 해제
			close(con);
			close(stm);
			close(rs);
			System.out.println("DB 종료");
		}
		return res; // 객체값을 저장한 리스트를 return을 이용하여 값을 보내준다
	}
	
// 상세 조회
	public MVCBoardDto selectOne(int seq) {
		return null;
	}
	
	// 추가
	public int insert(MVCBoardDto dto) {
		// 준비과정
		Connection con = getConnection(); // 연결
		PreparedStatement pstm= null; 
		int res =0 ; // 결과 값을 저장하는 공간
		
		String sql="INSERT INTO MVCBOARDTWO VALUES(NULL,?,?,?,now())"; // 실행할 SQL문을 변수에 저장
		
		try {
			pstm=con.prepareStatement(sql); // sql문을 가지고 연결을 함
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			 System.out.println("실행준비 완료: "+sql);
			
			res=pstm.executeUpdate(); // 업데이트를 실행
			System.out.println("업데이트 실행");
			if(res>0) { // 0보다 크면 업데이트 성공 , 0 이면 업데이트 실패
				commit(con);
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("업데이트 실패");
			e.printStackTrace();
		} finally {
			close(con);
			close(pstm);
		}
		return res; // 결과값 1 과 0 둘 중 하나를 반환하기 위해 res를 넘겨줌
	}
	// 삭제
	public int delete(MVCBoardDto dto) {
		return 0;
	}
	// 수정
	public int update(MVCBoardDto dto) {
		return 0;
	}
}
