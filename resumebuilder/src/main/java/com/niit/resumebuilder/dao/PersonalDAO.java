package com.niit.resumebuilder.dao;

import java.util.List;

import com.niit.resumebuilder.model.EducationalDetails;
import com.niit.resumebuilder.model.PersonalDetails;

public interface PersonalDAO {

	public boolean registerPersonalDetails(PersonalDetails pdetails);
	
	public boolean deletePersonalDetails(PersonalDetails pdetails);
	
	public boolean updatePersonalDetails(PersonalDetails pdetails);
	
	public List<PersonalDetails> list();


}
