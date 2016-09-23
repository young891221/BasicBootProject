package com.yj.service;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import com.google.common.collect.ImmutableMap;
import com.yj.model.Board;

public interface BoardService {
	public void insertBoard(Board board, Authentication authentication);
	
	public ImmutableMap<Object, Object> getBoardPage(Pageable pageable);
}
