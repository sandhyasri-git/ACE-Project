package com.niit.resumebuilder.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.resumebuilder.model.ExperienceDetails;

@Repository("experienceDAO")
@Transactional
public class ExperienceDAOImpl implements ExperienceDAO {

	@Autowired
	SessionFactory sessionFactory;
	public boolean registerExperience(ExperienceDetails experience) {
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.save(experience);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean deleteExperienceDetails(ExperienceDetails expdetails) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(expdetails);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("experience cannot be deleted");
			return false;
		}

	}
	public boolean updateExperienceDetails(ExperienceDetails expdetails) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(expdetails);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(" cannot be updated");
			return false;
		}

	}
	public List<ExperienceDetails> list() {
		try
		{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ExperienceDetails");
		
		List<ExperienceDetails> list = (List<ExperienceDetails>) query.list();
		session.close();
		
		return list;
		}
		
		catch(Exception e)
		{
			System.out.println("Cannot retrieve experience details");
			return null;
		}

	}

	
}
