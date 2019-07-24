package com.niit.resumebuilder.dao;

import java.util.List;

import com.niit.resumebuilder.model.EducationalDetails;

public interface EducationalDAO {

	public boolean registerEducationDetails(EducationalDetails edetails);
	public boolean deleteEducationDetails(EducationalDetails edetails);
	
	public boolean updateEducationalDetails(EducationalDetails edetails);
	
	public List<EducationalDetails> list();


}
