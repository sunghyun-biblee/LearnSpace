package com.login.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.login.dto.MyMemberDto;

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
}
