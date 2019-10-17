package com.csc.integral.omni.client.entity;

public class Profile {
	
	private String mobile;
	
	private String phone;
	
	private String dob;
	
	public Profile() {
		
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Profile(String mobile, String phone, String dob) {
		super();
		this.mobile = mobile;
		this.phone = phone;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Profile [mobile=" + mobile + ", phone=" + phone + ", dob=" + dob + "]";
	}
	
	

}
