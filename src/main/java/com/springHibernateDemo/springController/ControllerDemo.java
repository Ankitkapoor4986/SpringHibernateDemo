package com.springHibernateDemo.springController;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springHibernateDemo.dao.PersonDao;
import com.springHibernateDemo.hibernateEntities.Person;

@Controller
public class ControllerDemo {

	@Autowired
	PersonDao personDao;

	@RequestMapping("/hello")
	public ModelAndView hello(
			@RequestParam(value = "name", required = false) String name) {
		ModelAndView modelAndView = new ModelAndView("HelloFromSpringMVC");
		modelAndView.addObject("name", name);
		Person person = new Person();
		person.setName(name);
		person.setAge(29);
		
		

		personDao.insertPerson(person);
		return modelAndView;

	}

	@RequestMapping("/read")
	public ModelAndView read() {
		ModelAndView modelAndView=new ModelAndView("HelloFromSpringMVC");
		Person person=personDao.readPersonFromCriteriaQuery();
		modelAndView.addObject(person);
		
		return modelAndView;
		
	}
}
