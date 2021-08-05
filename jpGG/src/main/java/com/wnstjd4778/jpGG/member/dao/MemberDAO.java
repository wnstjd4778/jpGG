package com.wnstjd4778.jpGG.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wnstjd4778.jpGG.member.vo.MemberVO;

@Repository
public class MemberDAO {
//	@Autowired
//	private SqlSession sqlSession;
	
	public MemberVO login(Map loginMap) {
		MemberVO memberVO = new MemberVO("kim", "jun", null, null);
		return memberVO;
	}
	
//	public void addMember(MemberVO memberVO) {
//		sqlSession.insert("mapper.member.addMember",memberVO);
//	}
}
