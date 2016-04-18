package com.springHibernateDemo.springController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerDemo {
	@RequestMapping("/hello")
	public ModelAndView hello(
			@RequestParam(value="name" ,required=false) String name
			) {
		ModelAndView modelAndView=new ModelAndView("HelloFromSpringMVC");
			modelAndView.addObject("name",name );
				return modelAndView;
		
	}
	
}
