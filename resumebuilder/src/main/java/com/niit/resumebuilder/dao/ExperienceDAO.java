package com.niit.resumebuilder.dao;

import java.util.List;


import com.niit.resumebuilder.model.ExperienceDetails;

public interface ExperienceDAO {
	
	public boolean registerExperience(ExperienceDetails experience);
	

	
	public List<ExperienceDetails> list();
	
	public ExperienceDetails getWithPersonalDetailsId(Integer pid);
	
	public ExperienceDetails get(Integer id);



}
