package com.yj.service;

import org.springframework.security.core.Authentication;

import com.yj.model.Board;

public interface BoardService {
	public void insertBoard(Board board, Authentication authentication);
}
