package com.yj.repository;

import com.yj.model.Member;

public interface MemberRepository {
	public void insertOrUpdateMember(Member member);
	
	public boolean isEmail(String email);
	
}
