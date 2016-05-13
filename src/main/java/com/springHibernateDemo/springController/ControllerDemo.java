package com.springHibernateDemo.springController;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springHibernateDemo.dao.PersonDao;
import com.springHibernateDemo.hibernateEntities.Address;
import com.springHibernateDemo.hibernateEntities.Person;

@Controller
public class ControllerDemo {

	@Resource(name="personDaoImpl")
	PersonDao passsss;
	@Autowired
	@Qualifier("personDaoDummyImpl")
	PersonDao pppp;
	
	

	@RequestMapping("/hello")
	public ModelAndView hello(
			@RequestParam(value = "name", required = false) String name) {
		ModelAndView modelAndView = new ModelAndView("HelloFromSpringMVC");
		modelAndView.addObject("name", name);
		Person person = new Person();
		person.setName(name);
		person.setAge(29);
		Address address=new Address();
		address.setStreet("Street");
		address.setCity("city");
		address.setPerson(person);
		person.setAddress(address);
		
		passsss.insertPerson(person);
		return modelAndView;
		
		


	}

	@RequestMapping("/read")
	public ModelAndView read() {
		ModelAndView modelAndView=new ModelAndView("HelloFromSpringMVC");
		Person person=passsss.readPersonFromCriteriaQuery();
		modelAndView.addObject(person);
		
		return modelAndView;
		
	}
}
