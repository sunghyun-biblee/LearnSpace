package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest01 {
//		JDBC 실행 과정
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		1. DB 연결
		Class.forName("com.mysql.cj.jdbc.Driver");	// 드라이버 등록
		
		String url ="jdbc:mysql://localhost:3306/multi"; // 다른컴퓨터와 연결시 localhost 대신 연결할 컴퓨터 ip주소를 입력하면 된다.
		
//	  	localhost도 주소로 인식되어 앞에 // (슬래쉬)를 적어주어야 한다.
		String id ="root";
		String pw="1234";
		
		Connection con = DriverManager.getConnection(url,id,pw); //DMBS와 연결
		
		
//		2. sql 실행 및 결과 리턴
		
		Statement stmt = con.createStatement();  // 쿼리 실행하기 위한 statment 객체 생성
		
		String sql = "SELECT * FROM EMPLOYEE";
		ResultSet rs = stmt.executeQuery(sql); // 쿼리 실행 및 결과값 리턴
		
//		3. 결과값 처리
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt("SALARY"));
		}
		
		
		
//		4. db종료
		rs.close();
		stmt.close();
		con.close();
		
	}

}
