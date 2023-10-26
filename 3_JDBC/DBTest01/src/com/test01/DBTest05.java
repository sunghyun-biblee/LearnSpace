package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JDBCTemplate.*;

public class DBTest05 {
//	삭제
	public static void main(String[] args) {
//		준비 
		Connection con = null;
		PreparedStatement pstm = null;
		
		int res=0;
		
		String sql="DELETE FROM MYTEST WHERE MNAME=?";
		
		
//		입력
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 이름은? ");
		String name = sc.next();
		
//		쿼리실행
		try {
			con= getConnection();
			pstm=con.prepareStatement(sql);
			pstm.setString(1,name);
			
			res=pstm.executeUpdate();
			if(res>0) {
				System.out.println("delete 성공");
				commit(con);
			}else {
				System.out.println("delete 실패");
				rollback(con);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
//			DB 종료
			close(pstm);
			close(con);
			sc.close();
		}
		
		
	}

}
