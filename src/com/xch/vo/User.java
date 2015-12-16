package com.xch.vo;

public class User {
	private String uid;
	private String username;
	private String pwd;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String toString(){
		return this.uid +" " +this.pwd +" " +this.username;
	}
}
