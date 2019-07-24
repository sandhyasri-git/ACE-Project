package com.niit.resumebuilder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ExperienceDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int userId;
	private String employer;
	private String designation;
	private String joiningDate;
	private String leavingDate;

	@ManyToOne
	@JoinColumn(referencedColumnName="userid")
	private PersonalDetails pdetails;
	
	public PersonalDetails getPdetails() {
		return pdetails;
	}

	public void setPdetails(PersonalDetails pdetails) {
		this.pdetails = pdetails;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(String leavingDate) {
		this.leavingDate = leavingDate;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	private String experience;
	


}
