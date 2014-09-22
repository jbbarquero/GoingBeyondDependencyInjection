package com.pivotal.springone.security.custom;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	/*
	 * Fields supporting the standard UserDetails implementation 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	Set<GrantedAuthority> authorities;
	
	/*
	 * Custom properties of this user details object
	 */
	private String phone;
	private String email;
	
	/*
	 * These are the custom methods to facilitate the unique features of the custom UserDetails implementation
	 */
	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * Standard methods required by the UserDetails interface
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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
	
	@Override
	public String toString() {
		StringBuilder user = new StringBuilder("Username: " + username + "\t");
		                  user.append("Password: " + password + "\t");
		                  user.append("Roles: " + authorities);
		return user.toString();
	}

}
