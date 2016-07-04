package com.yj.service;

import com.yj.model.Member;
import com.yj.pojo.GoogleUser;

public interface MemberService {
	public void insertGoogleMember(GoogleUser googleUser);
	
	public boolean isEmail(String email);
	
	public void join(Member member);
}
