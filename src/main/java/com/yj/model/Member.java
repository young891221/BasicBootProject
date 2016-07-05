package com.yj.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "member")
public class Member {
	private int id;
	private String loginId;
	private String loginPw;
	private String name;
	private String email;
	private String image;
	private String phone;
	private String address;
	private DateTime insertDate;
	private int isSns;
	private MemberDetail memberDetail;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "member_id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "member_login_id")
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	@Column(name = "member_login_pw")
	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	@Column(name = "member_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "member_email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "member_image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "member_phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "member_address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "member_insert_date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(DateTime insertDate) {
		this.insertDate = insertDate;
	}

	@Column(name = "member_is_sns")
	public int getIsSns() {
		return isSns;
	}

	public void setIsSns(int isSns) {
		this.isSns = isSns;
	}

	@OneToOne(cascade=CascadeType.ALL, mappedBy="member") //MemberDetail's member
	public MemberDetail getMemberDetail() {
		return memberDetail;
	}

	public void setMemberDetail(MemberDetail memberDetail) {
		this.memberDetail = memberDetail;
	}
	

}
