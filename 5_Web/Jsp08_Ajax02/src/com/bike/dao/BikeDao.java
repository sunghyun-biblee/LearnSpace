package com.bike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.bike.dto.BikeDto;

import common.JDBCTemplate;

public class BikeDao extends JDBCTemplate{

	public int insert(List<BikeDto> dtos) {
		Connection con = getConnection();
		PreparedStatement pstm=null;
		
		int res=0;
		
		String sql="INSERT INTO BIKE_TB VALUES(?,?,?,?,?,?,?)";
		
		try {
			pstm=con.prepareStatement(sql);
			
			//일괄 처리
			int cnt=0;
			for (int i=0; i<dtos.size();i++) {
				BikeDto dto = dtos.get(i);
				
				pstm.setString(1, dto.getAddr_gu());
				pstm.setInt(2, dto.getContent_id());
				pstm.setString(3, dto.getContent_nm());
				pstm.setString(4,dto.getNew_addr());
				
				pstm.setInt(5, dto.getCradle_count());
				pstm.setDouble(6, dto.getLongitude());
				pstm.setDouble(7, dto.getLatitude());
				
				pstm.addBatch(); // 저장이 끝난 객체를 한쪽에 배치해둔다. (작업이 끝난 물건을 구석탱이에 놔둔다)
				cnt++;
				
			}
			System.out.println("query 준비: "+sql+"(총 "+cnt+"개)");
			
			int result[]=pstm.executeBatch(); // addBatch로 저장해둔 객체를 result에 한번에 저장한다
			System.out.println("query 실행");
			
			for(int i=0; i<result.length;i++) {
				if(result[i]==1) {
					res++;
				}
			}
			if(res==dtos.size()) { // 결과값 > 결과갯수가 같을 때
				commit(con); 
			}else {
				rollback(con);
			}
			
		} catch (SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
			
		} finally {
			close(pstm);
			close(con);
			System.out.println("db 종료");
		}
		
		
		
		return res;
		
	}
}
