package com.donate.bean;

import jakarta.persistence.*;

@Entity
@Table(name="DONOR_TBL")
public class Donor {
	@Id
    @Column(name="DONORID")
    private String donorID;

    @Column(name="FULLNAME")
    private String fullName;

    @Column(name="EMAIL")
    private String email;

    @Column(name="MOBILE")
    private String mobile;

    @Column(name="CITY")
    private String city;

    @Column(name="STATUS")
    private String status;
    public String getDonorID() {
		return donorID;
	}

	public void setDonorID(String donorID) {
		this.donorID = donorID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
	    return "Donor{" +
	            "donorID='" + donorID + '\'' +
	            ", fullName='" + fullName + '\'' +
	            ", email='" + email + '\'' +
	            ", mobile='" + mobile + '\'' +
	            ", city='" + city + '\'' +
	            ", status='" + status + '\'' +
	            '}';
	}

}