package com.niit.resumebuilder.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.resumebuilder.model.EducationalDetails;
import com.niit.resumebuilder.model.ExperienceDetails;
import com.niit.resumebuilder.model.PersonalDetails;

@Repository("educationalDAO")
@Transactional
public class EducationalDAOImpl implements EducationalDAO {

	@Autowired
	SessionFactory sessionFactory;
	public boolean registerEducationDetails(EducationalDetails edetails) {
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.save(edetails);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean deleteEducationDetails(EducationalDetails edetails) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(edetails);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("educational details cannot be deleted");
			return false;
		}
	}
	public boolean updateEducationalDetails(EducationalDetails edetails) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(edetails);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(" cannot be updated");
			return false;
		}
	}
	public List<EducationalDetails> list() {
		try
		{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from EducationalDetails");
		
		List<EducationalDetails> list = (List<EducationalDetails>) query.list();
		session.close();
		
		return list;
		}
		
		catch(Exception e)
		{
			System.out.println("Cannot retrieve educational details");
			return null;
		}
	}
	
}