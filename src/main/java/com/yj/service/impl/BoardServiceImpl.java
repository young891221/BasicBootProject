package com.yj.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yj.model.Board;
import com.yj.model.Member;
import com.yj.repository.BoardRepository;
import com.yj.repository.MemberRepository;
import com.yj.service.BoardService;

@Service
@Transactional(value="TransactionManager")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardRepository boardRepository;
	@Autowired MemberRepository memberRepository;
	
	@Override
	public void insertBoard(Board board, Authentication authentication) {
		Member member = memberRepository.selectMember(authentication.getName());
		board.setEditorId(member);
		board.setInsertDate(new DateTime().toDateTimeISO());
		boardRepository.insertOrUpdateBoard(board);
	}

}
