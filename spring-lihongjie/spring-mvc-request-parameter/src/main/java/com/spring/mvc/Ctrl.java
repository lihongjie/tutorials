package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ctrl {

	@RequestMapping(value="/welcome/user", method=RequestMethod.GET) 
	public ModelAndView showWelcomePage(@RequestParam(value="fName", required=true) String firstname, 
			@RequestParam(value="lName") String lastname) {

		String fullname = firstname + " " + lastname;
		System.out.println("Username is= " + fullname);

		ModelAndView m = new ModelAndView();
		m.addObject("fullname", fullname);
		m.setViewName("success");
		return m;
	}
}