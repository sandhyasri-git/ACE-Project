package com.niit.resumebuilder.dao;

import java.util.List;

import com.niit.resumebuilder.model.EducationalDetails;

public interface EducationalDAO {

	public boolean registerEducationDetails(EducationalDetails edetails);
	
	
	public List<EducationalDetails> list();
	
	
	public EducationalDetails getByPersonalDetailsId(Integer Id);


}
