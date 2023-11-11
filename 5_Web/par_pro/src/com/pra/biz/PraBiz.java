package com.pra.biz;

import java.util.List;

import com.pra.dto.PraDto;



public interface PraBiz {
	
	public List<PraDto> selectAll();
	public PraDto selectOne(int seq);
	public boolean insert(PraDto dto);
	public boolean update(PraDto dto);
	public boolean delete(int seq);

}
