package com.wnstjd4778.jpGG.vo;

public class SummonerVO {
	private String id;
	private String accountId;
	private String puuid;
	private String name;
	private int profileIconId;
	private int revisionDate;
	private int summonerLevel;
	public SummonerVO(String id, String accountId, String puuid, String name, int profileIconId, int revisionDate,
			int summonerLevel) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.puuid = puuid;
		this.name = name;
		this.profileIconId = profileIconId;
		this.revisionDate = revisionDate;
		this.summonerLevel = summonerLevel;
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
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the puuid
	 */
	public String getPuuid() {
		return puuid;
	}
	/**
	 * @param puuid the puuid to set
	 */
	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the profileIconId
	 */
	public int getProfileIconId() {
		return profileIconId;
	}
	/**
	 * @param profileIconId the profileIconId to set
	 */
	public void setProfileIconId(int profileIconId) {
		this.profileIconId = profileIconId;
	}
	/**
	 * @return the revisionDate
	 */
	public int getRevisionDate() {
		return revisionDate;
	}
	/**
	 * @param revisionDate the revisionDate to set
	 */
	public void setRevisionDate(int revisionDate) {
		this.revisionDate = revisionDate;
	}
	/**
	 * @return the summonerLevel
	 */
	public int getSummonerLevel() {
		return summonerLevel;
	}
	/**
	 * @param summonerLevel the summonerLevel to set
	 */
	public void setSummonerLevel(int summonerLevel) {
		this.summonerLevel = summonerLevel;
	}
	
	
	
}
