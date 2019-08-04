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
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(reg);
			return true;
		}

		catch (Exception e) {
			return false;
		}

	}

	public RegistrationDetails login(String email, String password) {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("From RegistrationDetails where emailId=:email and password=:password ",
							RegistrationDetails.class)
					.setParameter("email", email).setParameter("password", password).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public RegistrationDetails get(Integer id) {
		try {
			/*
			 * return sessionFactory.getCurrentSession()
			 * .createQuery("From RegistrationDetails where userId=:id",
			 * RegistrationDetails.class) .setParameter("id", id).getSingleResult();
			 */

			return sessionFactory.getCurrentSession().get(RegistrationDetails.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public RegistrationDetails get(String email) {
		try {
			return sessionFactory.getCurrentSession().createQuery("From RegistrationDetails where emailId=:email", RegistrationDetails.class)
			.setParameter("email", email)
			.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
