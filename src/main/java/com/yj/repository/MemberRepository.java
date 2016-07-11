package com.yj.repository;

import com.yj.model.Member;
import com.yj.model.MemberDetail;

public interface MemberRepository {
	public void insertOrUpdateMember(Member member);
	
	public boolean isEmail(String email);
	
	public void insertOrUpdateMemberDetail(MemberDetail memberDetail);
	
	public Member selectMember(String email);
}
