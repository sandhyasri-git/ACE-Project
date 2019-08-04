package com.niit.resumebuilder.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class PersonalDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	@NotNull
	private String firstname;
	@NotNull
	private String lastname;
	private String gender;
	private String dob;
	private String address;
	private String place;
	private String nationality;
	private String maritalStatus;
	private String knownlanguages;
	
	@OneToOne
	private RegistrationDetails regdetails;
	
	
	
	@OneToMany(mappedBy = "pdetails", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<EducationalDetails> edndetails = new ArrayList<EducationalDetails>();

	@OneToMany(mappedBy = "pdetails", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<ExperienceDetails> expdetails = new ArrayList<ExperienceDetails>();
	
	public RegistrationDetails getRegdetails() {
		return regdetails;
	}
	public void setRegdetails(RegistrationDetails regdetails) {
		this.regdetails = regdetails;
	}
	
	
	public List<ExperienceDetails> getExpdetails() {
		return expdetails;
	}
	public void setExpdetails(List<ExperienceDetails> expdetails) {
		this.expdetails = expdetails;
	}
	public List<EducationalDetails> getEdndetails() {
		return edndetails;
	}
	public void setEdndetails(List<EducationalDetails> edndetails) {
		this.edndetails = edndetails;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	private String hobbies;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getKnownlanguages() {
		return knownlanguages;
	}
	public void setKnownlanguages(String knownlanguages) {
		this.knownlanguages = knownlanguages;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}


	

}
