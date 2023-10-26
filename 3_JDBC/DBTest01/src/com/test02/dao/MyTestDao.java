package com.test02.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test02.dto.MyTest;

// DB연결
public class MyTestDao {

//	select
//	데이터가 얼마나 들어올지 모르기에 배열보다
//	크기가 가변적인 List가 효율적이다
	public List<MyTest> selectAll() {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		List<MyTest> res = new ArrayList<MyTest>();
		String sql = "SELECT * FROM MYTEST";

		try {
			// sql 실행 및 결과 리턴
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MyTest tmp = new MyTest(rs.getInt(1), rs.getString(2), rs.getString(3)); // 각 1,2,3번째 컬럼값을 가져와 하나의 객체를
																							// 만든다.
				res.add(tmp); // 객체를 res 리스트에 저장
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}

		return res;
	}

//	insert
	public int insert(MyTest mytest) {
//		준비
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO MYTEST VALUES(NULL,?,?)";

		try {
//			쿼리 실행 후 결과리턴
			pstm = con.prepareStatement(sql);
//			pstm.setInt(1, mytest.getMno());  // TESTVIEW INSERT (CASE 2: 참조)
			pstm.setString(1, mytest.getMname());
			pstm.setString(2, mytest.getNickname());
			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(pstm);

		}
		return res;

	}

//	update
	public int update(MyTest mytest) {
//		준비
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = "UPDATE MYTEST SET MNAME=? , NICKNAME=? WHERE MNO=?";

		try {
//			쿼리 실행 후 결과 리턴
			pstm = con.prepareStatement(sql);
			pstm.setString(1, mytest.getMname());
			pstm.setString(2, mytest.getNickname());
			pstm.setInt(3, mytest.getMno());

			res = pstm.executeUpdate(); // 결과처리
			if (res > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}

		return res;

	}

//	delete
	public int delete(int no) {
//		준비
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = "DELETE FROM MYTEST WHERE MNO=?";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, no);
			res = pstm.executeUpdate();

			if (res > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(pstm);

		}
		
		return res;
	}
}
