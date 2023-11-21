package com.mvc.upgrade.model.biz;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;

@Service // 해당하는 클래스는 비즈클래스로 등록되면서 사용가능 (의존성 주입) > 로직 처리 : @Service (서비스 레이어, 내부에서 자바 로직을 처리함)
public class BoardBizImpl implements BoardBiz{
	
	@Autowired //자동으로 생성되는 bean을 집어넣는다
	private BoardDao dao;

	@Override
	public List<BoardDto> selectList() {
		System.out.println("biz.selectList() 도착 ");
		return dao.selectList();
	}

	@Override
	public BoardDto selectOne(int myno) {
		System.out.println("biz.selectOne() 도착");
		
		return dao.selectOne(myno);
	}

	@Override
	public int insert(BoardDto dto) {
		
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		return dao.update(dto);
	}
	@Override
	public int delete(int myno) {
		return dao.delete(myno);
	}
	
	@Transactional(rollbackFor=SQLException.class)
	@Override
	public String test() {
		// 어느 한 부분에서라도 작업을 성공하지 못한다면 실패로 처리하기 위해서 , _transactional을 사용
		dao.insert(new BoardDto(0,"transaction","test","insert test transcation", null));
		String test=dao.test();
		//insert를 한 후에 억지로 exception 발생 > null.length(); 
		test.length();
		// 인서트가 된 후 트랜잭션에서 예외가 발생되어 기존에 인서트된 객체는 취소됐다 (Rollback) >> transactional 어노테이션을 사용하여 예외가 발생하였을때 transactionManager에서 관리할 수 있게 만듬
		return test;
	}
	


}
