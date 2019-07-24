package com.niit.resumebuilder.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.resumebuilder.model.PersonalDetails;

@Repository("personalDAO")
@Transactional
public class PersonalDAOImpl implements PersonalDAO {

	@Autowired
	SessionFactory sessionFactory;
	public boolean registerPersonalDetails(PersonalDetails pdetails) {
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.save(pdetails);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean deletePersonalDetails(PersonalDetails pdetails) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(pdetails);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("PersonalDetails cannot be deleted");
			return false;
		}
	}
	public boolean updatePersonalDetails(PersonalDetails pdetails) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(pdetails);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(" cannot be updated");
			return false;
		}
	}
	public List<PersonalDetails> list() {
		try
		{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from PersonalDetails");
		
		List<PersonalDetails> list = (List<PersonalDetails>) query.list();
		session.close();
		
		return list;
		}
		
		catch(Exception e)
		{
			System.out.println("Cannot retrieve Personal Details");
			return null;
		}

	}

}
