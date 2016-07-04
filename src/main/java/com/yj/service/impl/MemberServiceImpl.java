package com.yj.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yj.model.Member;
import com.yj.pojo.GoogleUser;
import com.yj.repository.MemberRepository;
import com.yj.service.MemberService;

@Service
@Transactional(value="TransactionManager")
public class MemberServiceImpl implements MemberService{

	@Autowired MemberRepository memberRepository;
	
	private Member memberGenerate(GoogleUser googleUser) {
		Member member = new Member();
	    member.setName(googleUser.getName());
	    member.setEmail(googleUser.getEmail());
	    member.setImage(googleUser.getPicture());
	    member.setInsertDate(new DateTime());
	    member.setIsSns(1);
		return member;
	}
	
	@Override
	public void insertGoogleMember(GoogleUser googleUser) {	    
	    memberRepository.insertOrUpdateMember(memberGenerate(googleUser));
	}

	@Override
	public boolean isEmail(String email) {
		return memberRepository.isEmail(email);
	}

	@Override
	public void join(Member member) {
		member.setInsertDate(new DateTime());
		member.setIsSns(0);
		memberRepository.insertOrUpdateMember(member);
	}
	
}
