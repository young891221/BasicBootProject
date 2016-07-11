package com.yj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.model.Board;
import com.yj.service.BoardService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired BoardService boardService;
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board() {
		return "board/boardForm";
	}

	@ResponseBody
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String insertBoard(@RequestBody Board board, Authentication authentication) {
		boardService.insertBoard(board, authentication);
		
		return "/dashboard";
	}
}
