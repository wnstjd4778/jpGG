package com.wnstjd4778.jpGG.vo;

public class LeagueEntryDTO implements Comparable<LeagueEntryDTO>{
	private String LeagueId;
	private String queueType;
	private String tier;
	private String rank;
	private int leaguePoints;
	private int wins;
	private int losses;
	
	/**
	 * @return the leagueId
	 */
	public String getLeagueId() {
		return LeagueId;
	}
	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	/**
	 * @return the leaguePoint
	 */
	public int getLeaguePoints() {
		return leaguePoints;
	}
	/**
	 * @param leaguePoint the leaguePoint to set
	 */
	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}
	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}
	/**
	 * @param wins the wins to set
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}
	/**
	 * @return the losses
	 */
	public int getLosses() {
		return losses;
	}
	/**
	 * @param losses the losses to set
	 */
	public void setLosses(int losses) {
		this.losses = losses;
	}
	/**
	 * @param leagueId the leagueId to set
	 */
	public void setLeagueId(String leagueId) {
		LeagueId = leagueId;
	}
	/**
	 * @return the queueType
	 */
	public String getQueueType() {
		return queueType;
	}
	/**
	 * @param queueType the queueType to set
	 */
	public void setQueueType(String queueType) {
		this.queueType = queueType;
	}
	/**
	 * @return the tier
	 */
	public String getTier() {
		return tier;
	}
	/**
	 * @param tier the tier to set
	 */
	public void setTier(String tier) {
		this.tier = tier;
	}
	/**
	 * @return the rank
	 */
	public LeagueEntryDTO(String leagueId, String queueType, String tier, String rank, int leaguePoints, int wins,
			int losses) {
		super();
		LeagueId = leagueId;
		this.queueType = queueType;
		this.tier = tier;
		this.rank = rank;
		this.leaguePoints = leaguePoints;
		this.wins = wins;
		this.losses = losses;
	}
	@Override
	public int compareTo(LeagueEntryDTO o) {
		return o.getQueueType().compareTo(this.queueType);
	}
	
	

}
