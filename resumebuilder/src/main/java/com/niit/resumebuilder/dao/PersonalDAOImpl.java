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
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(pdetails);
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}

	

	public List<PersonalDetails> list() {
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from PersonalDetails");

			List<PersonalDetails> list = (List<PersonalDetails>) query.list();
			session.close();

			return list;
		}

		catch (Exception e) {
			System.out.println("Cannot retrieve Personal Details");
			return null;
		}

	}

	public PersonalDetails getWithRegId(Integer regId) {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("From PersonalDetails where regdetails_userid=:regId", PersonalDetails.class)
					.setParameter("regId", regId).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public PersonalDetails get(Integer userId) {
		try {
			return sessionFactory.getCurrentSession().get(PersonalDetails.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}