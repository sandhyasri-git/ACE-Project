package com.niit.resumebuilder.dao;

import java.util.List;


import com.niit.resumebuilder.model.ExperienceDetails;

public interface ExperienceDAO {
	
	public boolean registerExperience(ExperienceDetails experience);
	
public boolean deleteExperienceDetails(ExperienceDetails expdetails);
	
	public boolean updateExperienceDetails(ExperienceDetails edetails);
	
	public List<ExperienceDetails> list();



}
