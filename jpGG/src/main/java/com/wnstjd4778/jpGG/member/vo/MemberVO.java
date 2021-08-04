package com.wnstjd4778.jpGG.member.vo;

public class MemberVO {
	private String memberId;
	private String memberPassword;
	private String memberEmail;
	private String memberPhoneNumber;
	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the memberPassword
	 */
	public String getMemberPassword() {
		return memberPassword;
	}
	/**
	 * @param memberPassword the memberPassword to set
	 */
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	/**
	 * @return the memberEmail
	 */
	public String getMemberEmail() {
		return memberEmail;
	}
	/**
	 * @param memberEmail the memberEmail to set
	 */
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	/**
	 * @return the memberPhoneNumber
	 */
	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}
	/**
	 * @param memberPhoneNumber the memberPhoneNumber to set
	 */
	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}
	public MemberVO(String memberId, String memberPassword, String memberEmail, String memberPhoneNumber) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
		this.memberPhoneNumber = memberPhoneNumber;
	}
	
}
