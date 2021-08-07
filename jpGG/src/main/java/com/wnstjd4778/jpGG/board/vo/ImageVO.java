package com.wnstjd4778.jpGG.board.vo;

import java.sql.Date;

public class ImageVO {
	private int imageFileNO;
	private String imageFileName;
	private Date regDate;
	private int articleNO;
	/**
	 * @return the imageFileNO
	 */
	public int getImageFileNO() {
		return imageFileNO;
	}
	/**
	 * @param imageFileNO the imageFileNO to set
	 */
	public void setImageFileNO(int imageFileNO) {
		this.imageFileNO = imageFileNO;
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
	 * @return the regDate
	 */
	public Date getRegDate() {
		return regDate;
	}
	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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
	public ImageVO(int imageFileNO, String imageFileName, Date regDate, int articleNO) {
		super();
		this.imageFileNO = imageFileNO;
		this.imageFileName = imageFileName;
		this.regDate = regDate;
		this.articleNO = articleNO;
	}

}
