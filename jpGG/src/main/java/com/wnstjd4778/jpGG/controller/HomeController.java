package com.wnstjd4778.jpGG.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wnstjd4778.jpGG.service.HomeService;
import com.wnstjd4778.jpGG.vo.LeagueEntryDTO;
import com.wnstjd4778.jpGG.vo.SummonerVO;
@RequestMapping(value="/a")
@Controller
public class HomeController {
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value="/memberForm" ,method={RequestMethod.POST,RequestMethod.GET})
	protected  ModelAndView viewForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("memberForm");
		return mav;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		return "home";
	}
	
	
	
	
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView result(@RequestParam("summonerName") String summonerName, HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		SummonerVO summonerVO = homeService.searchSummonerId(summonerName);
		LeagueEntryDTO leagueEntryDTO = homeService.searchSummonerTier(summonerVO.getId());
		mav.addObject("summonerVO", summonerVO);
		mav.addObject("leagueEntryDTO", leagueEntryDTO);
		mav.setViewName("result");
		return mav;
	}
	
}
