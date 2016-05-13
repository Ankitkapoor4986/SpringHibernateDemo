package com.springHibernateDemo.dao;

import com.springHibernateDemo.hibernateEntities.Person;

public interface PersonDao {

	public abstract void insertPerson(Person person);

	public abstract Person readPerson();

	public abstract Person readPersonFromCriteriaQuery();

}