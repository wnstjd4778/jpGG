package com.wnstjd4778.jpGG.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wnstjd4778.jpGG.board.vo.ArticleVO;
@Repository
public class BoardDAO {
//	@Autowired
//	private SqlSession sqlSession;
//	
//	public List<ArticleVO> listArticles() {
//		List<ArticleVO> articlesList = sqlSession.selectList("mapper.board.selectAllArticleList");
//		return articlesList;
//	}
//	
//	public int insertNewArticle(Map articleMap) {
//		int articleNO = selectNewArticleNO();
//		articleMap.put("articleNO", articleNO);
//		sqlSession.insert("mapper.board.selectNewArticle", articleMap);
//		return articleNO;
//	}
//	
//	public ArticleVO selectArticle(int articleNO) {
//		return sqlSession.selectOne("mapper.board.selectArticle", articleNO);
//	}
//	
//	public void updateArticle(Map articleMap) {
//		sqlSession.update("mapper.board.updateArticle",articleMap);
//	}
//	
//	public void deleteArticle(int articleNO) {
//		sqlSession.delete("mapper.board.deleteArticle", articleNO);
//	}
//	private int selectNewArticleNO() {
//		return sqlSession.selectOne("mapper.board.selectNewArticleNO");
//	}
//	
	

}
