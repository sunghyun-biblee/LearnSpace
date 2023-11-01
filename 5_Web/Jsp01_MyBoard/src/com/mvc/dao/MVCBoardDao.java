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
	// 전체 조회
	public List<MVCBoardDto> selectAll() {
		
		// 준비 
		Connection con = getConnection();
		Statement stmt=null;
		ResultSet rs= null;
		List<MVCBoardDto>res = new ArrayList<>();
		
		String sql="SELECT * FROM MVCBOARD ORDER BY SEQ ASC";
		
		try {
			stmt = con.createStatement();
			System.out.println("03. query 준비 : "+ sql);
			
			rs=stmt.executeQuery(sql);
			System.out.println("04. query 실행 및 리턴");
			
			while(rs.next()) {
				MVCBoardDto tmp=new MVCBoardDto();
				tmp.setSeq(rs.getInt(1));
				tmp.setWriter(rs.getString(2));
				tmp.setTitle(rs.getString(3));
				tmp.setContent(rs.getString(4));
				tmp.setRegdate(rs.getDate(5));
				
				res.add(tmp);
			}
		} catch (SQLException e) {	
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
			System.out.println("05. db 종료\n");
		}
		
		return res;
	}
	// 상세 조회
	public MVCBoardDto selectOne(int seq) {
		return null;
	}
	
	// 추가
	public int insert(MVCBoardDto dto) {
		// 준비
		Connection con = getConnection();
		PreparedStatement pstm=null; // 객체가 만들어질때
//		statment: 실행할떄
		int res=0;
		String sql="INSERT INTO MVCBOARD VALUES(NULL,?,?,?,now())";
		
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter()); // 첫번째 물음표에다가 가져온 객체의 writer값을 넣는다
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("03. query 준비 : "+ sql);
			
			res= pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
			if(res>0) { // res>0 : 업데이트를 성공했을 때 1을 반환 실패하면 0을 반환
				commit(con);
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println(" 추가 실패 ");
			e.printStackTrace();
		} finally {
			close(con);
			close(pstm);
			System.out.println("05. db종료\n");
		}
		return res;
	}
	// 수정
	public int update(MVCBoardDto dto) {
		return 0;
	}
	// 삭제
	public int delete(MVCBoardDto dto) {
		return 0;
	}
}
