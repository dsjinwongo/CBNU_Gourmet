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
	
	@RequestMapping("main")
	public String main(Model model) {
	  model.addAttribute("viewAll", boardService.viewAll());
	  return "board/main";
	}

	@RequestMapping("korea")
	public String korea(Model model) {
	  model.addAttribute("viewKorea", boardService.viewKorea());
	  return "board/korea";
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
}

