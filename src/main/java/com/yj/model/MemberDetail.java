package com.yj.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.joda.time.DateTime;

@Entity
@Table(name = "member_detail")
public class MemberDetail {
	private int id;
	private Member member;
	private int level;
	private String zipCode;
	private DateTime recentDate;
	private DateTime modify_date;
	private DateTime leave_date;
	private int isBlack;
	
	@Id
	@Column(name="member_id", unique=true, nullable=false)
	@GeneratedValue(generator="myGenerator")  
    @GenericGenerator(name="myGenerator", strategy="foreign", parameters=@Parameter(value="member", name = "property"))
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Member getMember() {
		return member;
	}
	public void setMember(Member memberId) {
		this.member = memberId;
	}
	@Column(name = "member_level")
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Column(name = "member_zip_code")
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Column(name = "member_recent_date")
	public DateTime getRecentDate() {
		return recentDate;
	}
	public void setRecentDate(DateTime recentDate) {
		this.recentDate = recentDate;
	}
	@Column(name = "member_modify_date")
	public DateTime getModify_date() {
		return modify_date;
	}
	public void setModify_date(DateTime modify_date) {
		this.modify_date = modify_date;
	}
	@Column(name = "member_leave_date")
	public DateTime getLeave_date() {
		return leave_date;
	}
	public void setLeave_date(DateTime leave_date) {
		this.leave_date = leave_date;
	}
	@Column(name = "member_is_black")
	public int getIsBlack() {
		return isBlack;
	}
	public void setIsBlack(int isBlack) {
		this.isBlack = isBlack;
	}
	
}
