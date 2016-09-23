package com.yj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yj.model.Board;
import com.yj.service.BoardService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private static final  int PAGE_SIZE = 10;
	@Autowired BoardService boardService;
	@Autowired protected ObjectMapper mapper;
	
	@RequestMapping(value = "/boardForm", method = RequestMethod.GET)
	public String board() {
		return "board/boardForm";
	}

	@ResponseBody
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String insertBoard(@RequestBody Board board, Authentication authentication) {
		boardService.insertBoard(board, authentication);
		
		return "/dashboard";
	}
	
	@ResponseBody
	@RequestMapping(value = "/listBoard", method = RequestMethod.POST)
	public String listBoard(Model model, @PageableDefault(page = 0, size = PAGE_SIZE) Pageable pageable) {
		try {
			model.addAttribute("boardList", mapper.writeValueAsString(boardService.getBoardPage(pageable)));
		} catch (JsonProcessingException e) {
			logger.error("boardList JsonProcessing error", e.getMessage());
		}
		
		return "/board/boardList";
	}
}
