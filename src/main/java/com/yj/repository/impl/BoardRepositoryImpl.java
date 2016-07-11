package com.yj.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yj.model.Board;
import com.yj.repository.BoardRepository;

@Repository
public class BoardRepositoryImpl implements BoardRepository{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insertOrUpdateBoard(Board board) {
		sessionFactory.getCurrentSession().saveOrUpdate(board);
	}

}
