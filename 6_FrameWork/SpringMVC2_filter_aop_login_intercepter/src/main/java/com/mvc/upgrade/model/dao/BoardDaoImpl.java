package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;


@Repository //빈 객체를 자동으로 생성 > 외부I/O 처리 : @Repository (퍼시스턴스 레이어, DB나 파일같은 외부 I/O 작업을 처리함)
public class BoardDaoImpl implements BoardDao {

	@Autowired //자동으로 bean객체 생성
	private SqlSessionTemplate sqlSession; //bean 객체를 사용하기위해
	
	@Override
	public List<BoardDto> selectList() {
		List<BoardDto> list =new ArrayList<BoardDto>();
		
		try { // 쿼리문을 실행해서 리스트에 저장해준다 > mybatis가 대신해줌	
			list = sqlSession.selectList(NAMESPACE+"selectList"); //myboard > namespace , selectlist > id / NAMESPACE+"selectList" => mybord.selectList
		} catch (Exception e) {
			System.out.println("[error]: selectList");
			e.printStackTrace();
		}
		 
		
		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		BoardDto dto=null;
		
		try {
			// String NAMESPCAE = "myboard."
			dto=sqlSession.selectOne(NAMESPACE+"selectOne",myno); // 어떤 게시글을 조회할지 알기위해 myno값을 넘겨준다.
		} catch (Exception e) {
			System.out.println("[error] : selectOne");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		int res=0;
		
		try {
			res=sqlSession.insert(NAMESPACE+"insert",dto);
		} catch (Exception e) {
			System.out.println("[error]: insert");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(BoardDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE+"update", dto);
		} catch (Exception e) {
			System.out.println("[error] : update");
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	
	@Override
	public int delete(int myno) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"delete", myno);
		} catch (Exception e) {
			System.out.println("[error] : delete");
			e.printStackTrace();
		}
		
		return res;
	}

}
