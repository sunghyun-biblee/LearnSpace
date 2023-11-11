package com.pra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pra.dto.PraDto;
import static common.JDBCTemplate.*;

public class PraDaoImpl implements PraDao {

	@Override
	public List<PraDto> selectAll(Connection con) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		List<PraDto> res=new ArrayList<PraDto>();
		
		try {
			pstm=con.prepareStatement(selectAllSql);
			System.out.println("query 준비"+ selectAllSql);
			
			rs=pstm.executeQuery();
			
			while(rs.next()) {
				PraDto tmp=new PraDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
				res.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db종료");
		} finally {
			close(pstm);
			close(rs);
		}
		
		return res;
	}

	@Override
	public PraDto selectOne(Connection con, int seq) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		PraDto res= new PraDto();
		try {
			pstm=con.prepareStatement(selectOneSql);
			pstm.setInt(1, seq);
			System.out.println("query 준비:"+ selectOneSql);
			
			rs=pstm.executeQuery();
			System.out.println("query 실행");
			
			while(rs.next()) {
				res.setSeq(rs.getInt("SEQ"));
				res.setWriter(rs.getString(2));
				res.setTitle(rs.getString(3));
				res.setContent(rs.getString(4));
				res.setRegdate(rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("3/4 단계 에러");
		} finally {
			close(pstm);
			close(rs);
		}
		return res;
	}

	@Override
	public boolean insert(Connection con, PraDto dto) {
		PreparedStatement pstm=null;
		int res=0;
		
		try {
			pstm=con.prepareStatement(insertSql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("query 준비: "+ insertSql);
			
			res=pstm.executeUpdate();
			System.out.println("query 실행");
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("3/4단계 에러");
		} finally {
			close(pstm);
		}
		
		return (res>0)?true:false;
	}

	@Override
	public boolean update(Connection con, PraDto dto) {
		PreparedStatement pstm=null;
		int res=0;
		
		try {
			pstm=con.prepareStatement(updateSql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("query 준비:"+ updateSql);
			
			res=pstm.executeUpdate();
			System.out.println("query 실행");
			
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
		}
		
		
		return (res>0)?true:false;
	}

	@Override
	public boolean delete(Connection con, int seq) {
		return false;
	}

}
