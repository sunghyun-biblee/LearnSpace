package com.login.dao;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.dto.MyMemberDto;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.mysql.cj.xdevapi.Result;

public class MyMemberDao {
	// 로그인 기능
	
	public MyMemberDto login(String id, String pw) {
		// 준비
		Connection con = getConnection();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		 // id가 not null , unique 이기때문에 중복불가 , 아무리 셀렉하더라도 한개만 가져옴
		MyMemberDto res=new MyMemberDto();
		
		// 로그인을 성공하기위해 ID와 PW가 모두 일치해야함 그리고 가입여부가 Y(가입중)일떄만 로그인 , 탈퇴했는데 로그인이되면 안되기 떄문에
		String sql = "SELECT * FROM MYMEMBER WHERE MYID=? AND MYPW=? AND MYENABLED=?"; // 쿼리문을 나눠서 작성할려면 앞뒤로 공백을 넣어야함
		
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			pstm.setString(3, "Y"); // 가입중이여야 로그인이 되기때문에 Y를 넣어 조회하여 Y가 아니라면 실패처리로 로그인실패를 출력
			System.out.println("query 준비:"+ sql);
			
			rs=pstm.executeQuery();
			System.out.println("query 실행");
			
			while(rs.next()) { // rs안에 있는 데이터들의 컬럼이 존재하지 않을때까지 읽는다.
				res.setMyno(rs.getInt(1));
				res.setMyid(rs.getString(2));
				res.setMypw(rs.getString(3));
				res.setMyname(rs.getString(4));
				res.setMyaddr(rs.getString(5));
				res.setMyphone(rs.getString(6));
				res.setMyemail(rs.getString(7));
				res.setMyenabled(rs.getString(8));
				res.setMyrole(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("3/4단계 에러");
		} finally {
			close(con);
			close(pstm);
			close(rs);
			System.out.println("db 종료");
		}
		
		return res;
	}
	
	public List<MyMemberDto> selectAll() {
		Connection con =getConnection();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		List<MyMemberDto> res=new ArrayList<MyMemberDto>();
		
		
		String sql="SELECT * FROM MYMEMBER ORDER BY MYNO DESC";
		try {
			pstm=con.prepareStatement(sql);
			System.out.println("query 준비:"+ sql);
			rs=pstm.executeQuery();
			System.out.println("query 실행");
			
			while(rs.next()) {
				MyMemberDto tmp=new MyMemberDto();
				tmp.setMyno(rs.getInt(1));
				tmp.setMyid(rs.getString(2));
				tmp.setMypw(rs.getString(3));
				tmp.setMyname(rs.getString(4));
				tmp.setMyaddr(rs.getString(5));
				tmp.setMyphone(rs.getString(6));
				tmp.setMyemail(rs.getString(7));
				tmp.setMyenabled(rs.getString(8));
				tmp.setMyrole(rs.getString(9));
				
				res.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("3/4단계 에러");
		} finally{
			close(rs);
			close(pstm);
			close(con);
			System.out.println("db종료");
		}
		return res;
	}
	
	// id 중복 확인
	public String idChk(String id){
		Connection con = getConnection();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String res=null;
		
		String sql="SELECT * FROM MYMEMBER WHERE MYID=?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, id); // 매개변수로 받은 id를 참조
			
			rs=pstm.executeQuery();
			
			while(rs.next()) {
				res=rs.getString(2); // id 값만 가져옴
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(con);
			close(pstm);
		}
		
		return res;
	}
	
	// 회원가입
	public int insertUser(MyMemberDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm=null;
		int res=0;
		
		String sql=" INSERT INTO MYMEMBER VALUES(NULL,?,?,?,?,?,?,'Y','USER') ";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, dto.getMyid());
			pstm.setString(2, dto.getMypw());
			pstm.setString(3, dto.getMyname());
			pstm.setString(4, dto.getMyaddr());
			pstm.setString(5, dto.getMyphone());
			pstm.setString(6, dto.getMyemail());
			System.out.println("query 준비"+sql);
			
			res=pstm.executeUpdate();
			System.out.println("query 실행");
			
			if(res>0) {
				commit(con);
				rollback(con);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(pstm);
			System.out.println("db 종료");
		}
		
		return res;
	}
	
	public int deleteUser(int myno) {
		Connection con= getConnection();
		PreparedStatement pstm=null;
		int res=0;
		
		String sql=" UPDATE MYMEMBER SET MYENABLED='N' WHERE MYNO=? ";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("query 준비:"+ sql);
			
			res=pstm.executeUpdate();
			System.out.println("query 실행");
			
			if(res>0) {
				commit(con);
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("3/4단계 에러");
		} finally {
			close(con);
			close(pstm);
			System.out.println("db 종료");
		}
		return res;
	}
}
