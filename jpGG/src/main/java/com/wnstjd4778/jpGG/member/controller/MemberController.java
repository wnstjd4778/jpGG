package com.wnstjd4778.jpGG.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wnstjd4778.jpGG.member.service.MemberService;
import com.wnstjd4778.jpGG.member.vo.MemberVO;

@Controller
@RequestMapping(value="/member", method=RequestMethod.POST)
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, String> loginMap,
							HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MemberVO memberVO = memberService.login(loginMap);
		
		mav.addObject("memberVO", memberVO);
		mav.setViewName("loginForm");
		return mav;
	}

}
