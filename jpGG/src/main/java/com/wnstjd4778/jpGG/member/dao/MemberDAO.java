package com.wnstjd4778.jpGG.member.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wnstjd4778.jpGG.member.vo.MemberVO;

@Repository
public class MemberDAO {
	
	public MemberVO login(Map loginMap) {
		MemberVO memberVO = new MemberVO("kim", "jun", null, null);
		memberVO.setMemberId("kim");
		memberVO.setMemberPassword("a");
		return memberVO;
	}
}
