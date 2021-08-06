package com.wnstjd4778.jpGG.ranker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wnstjd4778.jpGG.ranker.service.RankerService;
import com.wnstjd4778.jpGG.ranker.vo.RankerVO;

@Controller
@RequestMapping(value="ranker", method= {RequestMethod.GET, RequestMethod.POST})
public class RankerController {
	@Autowired
	private RankerService rankerService;
	
	
	@RequestMapping(value="/solo", method=RequestMethod.GET)
	public ModelAndView searchSoloRanker(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		List<RankerVO> list = rankerService.searchSoloRanker();
		mav.addObject("list", list);
		mav.setViewName("ranker");
		return mav;
	}

	
}
