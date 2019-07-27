package com.resumefront.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.resumebuilder.dao.RegisterDAO;
import com.niit.resumebuilder.model.RegistrationDetails;

@Controller
public class HomeController {
	
	@Autowired
	RegisterDAO registerDAO;
	@RequestMapping("/")
	public String showHome() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("registrationdetails", new RegistrationDetails());
		return "registration";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("registrationdetails") RegistrationDetails registrationdetails, BindingResult result, HttpServletRequest request) {
		System.out.println("Here");
		System.out.println(registrationdetails.getEmailId());

		String email = registrationdetails.getEmailId();
		registerDAO.registerUser(registrationdetails);
		return "login";
		
	}

}
