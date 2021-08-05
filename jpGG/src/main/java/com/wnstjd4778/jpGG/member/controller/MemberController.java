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
@RequestMapping(value="/member", method={RequestMethod.POST,RequestMethod.GET})
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login", method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView login(@RequestParam Map<String, String> loginMap,
							HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		MemberVO memberVO = memberService.login(loginMap);
		if(memberVO!= null && memberVO.getMemberId()!=null){
			HttpSession session = request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("memberVO", memberVO);
			session.setMaxInactiveInterval(10);
		}
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value="/logout", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.setAttribute("isLogOn", false);
		session.removeAttribute("memberVO");
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value="/addMember", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView addMember(@RequestParam MemberVO memberVO, 
									HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		memberService.addMember(memberVO);
		return mav;
	}
	

}
