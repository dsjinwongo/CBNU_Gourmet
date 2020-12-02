package com.mytest.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.mytest.test.service.BoardService;

@Controller
@RequestMapping("")
public class Maincontroller {
	@Autowired
	private BoardService boardService;

	@RequestMapping("test")
	public String test(Model model) {
	  model.addAttribute("viewAll", boardService.viewAll());
	  return "board/test";
	}
	
	@RequestMapping("board")
	public String board(Model model) {
		model.addAttribute("viewAll", boardService.viewAll());
		return "board/boardList";
	}
}

