package com.springHibernateDemo.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
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
	
	public Person readPerson(){
		Person person=null;
		Session session=sessionFactory.getObject().openSession();
		person=(Person) session.get(Person.class, 1L);
		session.close();
		return person;
	}
	
	public Person readPersonFromCriteriaQuery(){
		
		Session session=sessionFactory.getObject().openSession();
		Query query=session.createQuery("select  p.name as name from Person p");
		query.setResultTransformer(Transformers.aliasToBean(Person.class));
		List<Person> personList=query.list();
		session.close();
		return personList.get(0);
	}
	
}
