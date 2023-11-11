package com.pra.biz;

import java.sql.Connection;
import java.util.List;

import com.pra.dao.PraDao;
import com.pra.dao.PraDaoImpl;
import com.pra.dto.PraDto;

import static common.JDBCTemplate.*;
public class PraBizImpl implements PraBiz {

		private PraDao dao=new PraDaoImpl();
	@Override
	public List<PraDto> selectAll() {
		Connection con = getConnection();
		
		List<PraDto> res= dao.selectAll(con);
		
		close(con);
		System.out.println("db 종료");
	
		return res;
	}

	@Override
	public PraDto selectOne(int seq) {
		Connection con = getConnection();
		
		PraDto res=dao.selectOne(con, seq);
		close(con);
		System.out.println("DB 종료");
		return res;
	}

	@Override
	public boolean insert(PraDto dto) {
		Connection con=getConnection();
		boolean res=dao.insert(con, dto);
		if(res) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		System.out.println("db종료");
		return res;
	}

	@Override
	public boolean update(PraDto dto) {
		return false;
	}

	@Override
	public boolean delete(int seq) {
		return false;
	}

}
