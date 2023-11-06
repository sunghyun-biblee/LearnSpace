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
		// 준비
		Connection con = getConnection();
		PreparedStatement pstm=null;
		ResultSet rs= null;
		MVCBoardDto res=new MVCBoardDto(); // resultset에 담겨있는 객체를 옮겨닮을 공간
		
		String sql="SELECT * FROM MVCBOARD WHERE SEQ=?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, seq);
			System.out.println("query 준비 : "+sql);
			
			rs=pstm.executeQuery();
			System.out.println("query 실행 및 리턴");
			
			while(rs.next()) {
				res.setSeq(rs.getInt("SEQ"));
				res.setWriter(rs.getString(2));
				res.setTitle(rs.getString(3));
				res.setContent(rs.getString(4));
				res.setRegdate(rs.getDate(5));
			}
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		} finally {
			close(con);
			close(pstm);
			close(rs);
		}
		
		return res;
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
		Connection con = getConnection();
		PreparedStatement pstm=null;
		int res=0;
		
		String sql="UPDATE MVCBOARD SET TITLE=?, CONTENT=? WHERE SEQ=? ";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1,dto.getTitle());
			pstm.setString(2,dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("query 준비: "+sql);
			
			res=pstm.executeUpdate();
			System.out.println("query 실행 ");
			if(res>0) {
				commit(con);
				rollback(con); // 지금 트랜잭션에서 하나만 실행하기때문에 실패해도 결과가 바뀌는게 없기때문에 굳이 사용 안해도 된다
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("3/4 단계 에러");
		} finally {
			close(con);
			close(pstm);
		}
		
		return res;
	}
	// 삭제
	public int delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm=null;
		int res=0;
		
		String sql="DELETE FROM MVCBOARD WHERE SEQ=?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1,seq);
			System.out.println("query 준비 :" +sql);
			
			res=pstm.executeUpdate();
			System.out.println("query 실행");
			if(res>0) {
				commit(con);
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		} finally {
			close(con);
			close(pstm);
			System.out.println("db 종료");
		}
		
		
		return res;
	}
}
