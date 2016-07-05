package com.yj.repository.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yj.model.Member;
import com.yj.model.MemberDetail;
import com.yj.repository.MemberRepository;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	private static final Logger logger = LoggerFactory.getLogger(MemberRepositoryImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void insertOrUpdateMember(Member member) {
		sessionFactory.getCurrentSession().saveOrUpdate(member);
	}

	@Override
	public boolean isEmail(String email) {
		Object isEmail = sessionFactory.getCurrentSession().createCriteria(Member.class)
						.add(Restrictions.eq("email", email)).uniqueResult();
		if(isEmail == null) {
			return false;
		}
		return true;
	}

	@Override
	public void insertOrUpdateMemberDetail(MemberDetail memberDetail) {
			sessionFactory.getCurrentSession().saveOrUpdate(memberDetail);
	}

}
