package com.wnstjd4778.jpGG.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnstjd4778.jpGG.board.dao.BoardDAO;
import com.wnstjd4778.jpGG.board.vo.ArticleVO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	public List<ArticleVO> listArticles() {
		return boardDAO.listArticles();
	}
	
	public int addNewArticle(Map articleMap) {
		return boardDAO.insertNewArticle(articleMap);
	}
	public ArticleVO viewArticle(int articleNO) {
		return boardDAO.selectArticle(articleNO);
	}
	
	public void modArticle(Map articleMap) {
		boardDAO.updateArticle(articleMap);
	}
	public void deleteArticle(int articleNO) {
		boardDAO.deleteArticle(articleNO);
	}
}
