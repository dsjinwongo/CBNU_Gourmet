package com.mytest.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mytest.test.domain.BoardVO;
import com.mytest.test.service.BoardService;

@Controller
@RequestMapping("")
public class Boardcontroller {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("board")
	public String board(Model model) {
		model.addAttribute("viewAll", boardService.viewAll());
		return "board/boardList";
	}

	@RequestMapping("korea")
	public String korea(Model model) {
	  model.addAttribute("viewKorea", boardService.viewKorea());
	  return "board/korea";
	}
	
	@RequestMapping("dessert")
	public String dessert(Model model) {
	  model.addAttribute("viewDessert", boardService.viewDessert());
	  return "board/dessert";
	}
	
	@RequestMapping("america")
	public String america(Model model) {
		model.addAttribute("viewAmerica", boardService.viewAmerica());
		return "board/america";
	}
	
	@RequestMapping("china")
	public String china(Model model) {
		model.addAttribute("viewChina", boardService.viewChina());
		return "board/china";
	}
	
	@GetMapping("write")
	public String boardWrite() {
	  return "board/boardWrite";
	}
	
	@GetMapping("detail")
	public String viewDetail(Model model, @RequestParam("seq")int seq) {
	  
	  model.addAttribute("board", boardService.viewDetail(seq));
	  
	  boardService.plusCnt(seq);
	  
	  return "board/viewDetail";
	}
	
	@PostMapping("write")
	public String write(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect: /detail?seq="+ vo.getSeq();
	}
}

