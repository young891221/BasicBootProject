package com.yj.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String email;
	private String picture;
	private String gender;
	private String locale;
	private DateTime signdate;
	private DateTime lastDate;
	private Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public DateTime getSigndate() {
		return signdate;
	}

	public void setSigndate(DateTime signdate) {
		this.signdate = signdate;
	}

	public DateTime getLastDate() {
		return lastDate;
	}

	public void setLastDate(DateTime lastDate) {
		this.lastDate = lastDate;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Collection<SimpleGrantedAuthority> authorities) {
		if (authorities != null) {
			this.authorities = authorities;
		}
	}

	public void addAuthority(SimpleGrantedAuthority auth) {
		this.authorities.add(auth);
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public static UserDetailImpl changeUser(GoogleUser googleUser) {
		UserDetailImpl user = new UserDetailImpl();
		
		user.name = googleUser.getName();
		user.email = googleUser.getEmail();
		user.gender = googleUser.getGender();
		user.locale = googleUser.getLocale();
		user.picture = googleUser.getPicture();
		//user.authorities = getAuthorities(googleUser.getRoleList());
		return user;
	}

	private static List<SimpleGrantedAuthority> getAuthorities(List<String> roleList) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		for (String descentdant : roleList) {
			authorities.add(new SimpleGrantedAuthority(descentdant));
		}

		return authorities;
	}

}