package com.mytest.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytest.test.mapper.BoardMapper;
import com.mytest.test.service.BoardService;

import com.mytest.test.domain.AmericaVO;
import com.mytest.test.domain.BoardVO;
import com.mytest.test.domain.ChinaVO;
import com.mytest.test.domain.KoreaVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> viewAll() {
		return mapper.viewAll();
	}
	
	@Override
	public List<KoreaVO> viewKorea() {
		return mapper.viewKorea();
	}

	@Override
	public List<AmericaVO> viewAmerica() {
		return mapper.viewAmerica();
	}
	
	@Override
	public List<ChinaVO> viewChina() {
		return mapper.viewChina();
	}
	
	@Override
	public BoardVO viewDetail(int seq) {
	  return mapper.viewDetail(seq);
	}
	
	@Override
	public boolean plusCnt(int seq) {
	  return mapper.plusCnt(seq);
	}
	
	@Override
	public int insertBoard(BoardVO vo) {
		return mapper.insertBoard(vo);
	}
}
