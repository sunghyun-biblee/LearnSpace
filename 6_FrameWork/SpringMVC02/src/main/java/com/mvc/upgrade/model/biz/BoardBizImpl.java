package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

		return 0;
	}

	@Override
	public int delete(int myno) {
		
		return 0;
	}

	


}
