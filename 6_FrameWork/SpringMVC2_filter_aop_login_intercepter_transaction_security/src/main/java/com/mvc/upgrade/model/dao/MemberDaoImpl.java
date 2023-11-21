package com.mvc.upgrade.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public MemberDto login(MemberDto dto) {
		
		MemberDto res= null;
		try {
			res=sqlSession.selectOne(NAMESPACE+"login",dto);  // NAMESPACE = "mymember."
			
		} catch (Exception e) {
			System.out.println("error : memberDaoImpl - login");
			e.printStackTrace();
		}
		System.out.println(res.getMemberid());
		return res;
	}


	@Override
	public int insert(MemberDto dto) { // 회원가입 메소드
		int res=0;
		
		try {
			res=sqlSession.insert(NAMESPACE+"insert",dto);
		} catch (Exception e) {
			System.out.println("error : memberDao - insert");
			e.printStackTrace();
		}
		
		return res;
	}

}