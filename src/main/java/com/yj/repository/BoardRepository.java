package com.yj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.yj.model.Board;

public interface BoardRepository {
	public void insertOrUpdateBoard(Board board);
	
	public Page<Board> selectBoardPage(Pageable pageable);
	
	public Long getTotal();
}
