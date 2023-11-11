package com.pra.dao;

import java.sql.Connection;
import java.util.List;

import com.pra.dto.PraDto;

public interface PraDao {
	
	
	String selectAllSql="SELECT * FROM MYPRABOARD ORDER BY SEQ DESC";
	String selectOneSql="SELECT * FROM MYPRABOARD WHERE SEQ=?";
	String insertSql="INSERT INTO MYPRABOARD VALUES(NULL,?,?,?,NOW())";
	String updateSql="UPDATE MYPRABOARD SET TITLE=?,CONTENT=? WHERE SEQ=?";
	String deleteSql="DELETE FROM MYPRABOARD WHERE SEQ=?";
	
	public List<PraDto> selectAll(Connection con);
	public PraDto selectOne(Connection con , int seq);
	public boolean insert(Connection con,PraDto dto);
	public boolean update(Connection con,PraDto dto);
	public boolean delete(Connection con,int seq);
	
}
