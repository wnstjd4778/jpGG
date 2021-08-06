package com.wnstjd4778.jpGG.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnstjd4778.jpGG.member.dao.MemberDAO;
import com.wnstjd4778.jpGG.member.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberVO login(Map loginMap) {
		return memberDAO.login(loginMap);
	}
	
	public void addMember(MemberVO memberVO) {
		//memberDAO.addMember(memberVO);
	}

}
