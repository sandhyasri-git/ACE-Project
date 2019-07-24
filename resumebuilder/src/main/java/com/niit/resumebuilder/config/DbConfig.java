package com.niit.resumebuilder.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.resumebuilder.model.EducationalDetails;
import com.niit.resumebuilder.model.ExperienceDetails;
import com.niit.resumebuilder.model.PersonalDetails;
import com.niit.resumebuilder.model.RegistrationDetails;

@Configuration
@EnableTransactionManagement
@ComponentScan("com")

public class DbConfig {

	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/resumedb");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		System.out.println("DataSource Object Created");
		
		return dataSource;	
	}

	private Properties getHibernateProperties()
	{
		Properties prop=new Properties();
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.hbm2ddl.auto", "update");
		
		System.out.println("Hibernate Properties");
		return prop;
	}

	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory  getSessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(datasource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(ExperienceDetails.class);
		sessionBuilder.addAnnotatedClass(EducationalDetails.class);
		sessionBuilder.addAnnotatedClass(PersonalDetails.class);
		sessionBuilder.addAnnotatedClass(RegistrationDetails.class);
		System.out.println("Session Factory");
		return sessionBuilder.buildSessionFactory();
	}
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("HibernateTransactionManager Object Created");

		return new HibernateTransactionManager(sessionFactory);
	}


}
