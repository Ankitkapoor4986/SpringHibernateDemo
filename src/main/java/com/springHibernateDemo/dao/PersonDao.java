package com.springHibernateDemo.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.springHibernateDemo.hibernateEntities.Person;

@Repository
public class PersonDao {
	@Autowired
	LocalSessionFactoryBean sessionFactory ;
	public void insertPerson(Person person){
	
		Session session=sessionFactory.getObject().openSession();
		session.save(person);
		session.close();
	}
	
}
