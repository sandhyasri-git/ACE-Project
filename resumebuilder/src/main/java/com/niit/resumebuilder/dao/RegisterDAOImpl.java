package com.niit.resumebuilder.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.resumebuilder.model.RegistrationDetails;

@Repository("registerDAO")
@Transactional
public class RegisterDAOImpl implements RegisterDAO {

	@Autowired
	SessionFactory sessionFactory;
	public boolean registerUser(RegistrationDetails reg) {
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.save(reg);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}

	}

}
