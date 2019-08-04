package com.niit.resumebuilder.dao;

import com.niit.resumebuilder.model.RegistrationDetails;

public interface RegisterDAO {

	public boolean registerUser(RegistrationDetails reg);
	public RegistrationDetails login(String email,String password);
	public RegistrationDetails get(Integer id);
	public RegistrationDetails get(String email);
}
