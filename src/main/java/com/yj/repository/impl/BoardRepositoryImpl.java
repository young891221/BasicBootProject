package com.yj.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.yj.model.Board;
import com.yj.repository.BoardRepository;
import com.yj.repository.CrudRepositoryAbstract;

@Repository
public class BoardRepositoryImpl extends CrudRepositoryAbstract<Board, Serializable> implements BoardRepository{
	
	@Override
	public void insertOrUpdateBoard(Board board) {
		saveOrUpdate(board);
	}

	@Override
	public Page<Board> selectBoardPage(Pageable pageable) {
		List<Board> items = getCurrentSession().createCriteria(Board.class)
				.setFirstResult(pageable.getOffset())
				.setMaxResults(pageable.getPageSize())
				.addOrder(Order.desc("id"))
				.list();
		return new PageImpl<Board>(items, pageable, this.getTotal());
	}

	@Override
	public Long getTotal() {
		return ((Long) getCurrentSession().createCriteria(Board.class)
				.setProjection(Projections.rowCount())
				.uniqueResult()).longValue();
	}

}
