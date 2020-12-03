package com.mytest.test.mapper;

import java.util.List;

import com.mytest.test.domain.AmericaVO;
import com.mytest.test.domain.BoardVO;
import com.mytest.test.domain.ChinaVO;
import com.mytest.test.domain.KoreaVO;

public interface BoardMapper {
	public List<BoardVO> viewAll();
	public List<KoreaVO> viewKorea();
	public List<AmericaVO> viewAmerica();
	public List<ChinaVO> viewChina();
}