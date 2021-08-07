package com.wnstjd4778.jpGG.board.vo;

import java.sql.Date;

public class ArticleVO {
	private int  level;
	private int articleNO;
	private int parentNO;
	private String title;
	private String content;
	private String imageFileName;
	private String id;
	private Date  writeDate;
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the articleNO
	 */
	public int getArticleNO() {
		return articleNO;
	}
	/**
	 * @param articleNO the articleNO to set
	 */
	public void setArticleNO(int articleNO) {
		this.articleNO = articleNO;
	}
	/**
	 * @return the parentNO
	 */
	public int getParentNO() {
		return parentNO;
	}
	/**
	 * @param parentNO the parentNO to set
	 */
	public void setParentNO(int parentNO) {
		this.parentNO = parentNO;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}
	/**
	 * @param imageFileName the imageFileName to set
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the writeDate
	 */
	public Date getWriteDate() {
		return writeDate;
	}
	/**
	 * @param writeDate the writeDate to set
	 */
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public ArticleVO(int level, int articleNO, int parentNO, String title, String content, String imageFileName,
			String id, Date writeDate) {
		super();
		this.level = level;
		this.articleNO = articleNO;
		this.parentNO = parentNO;
		this.title = title;
		this.content = content;
		this.imageFileName = imageFileName;
		this.id = id;
		this.writeDate = writeDate;
	}

}
