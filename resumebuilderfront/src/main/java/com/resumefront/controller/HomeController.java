package com.resumefront.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.resumebuilder.dao.PersonalDAO;
import com.niit.resumebuilder.dao.RegisterDAO;
import com.niit.resumebuilder.model.PersonalDetails;
import com.niit.resumebuilder.model.RegistrationDetails;

@Controller
public class HomeController {

	@Autowired
	RegisterDAO registerDAO;

	@Autowired
	private PersonalDAO personalDAO;

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
	public String addUser(@ModelAttribute("registrationdetails") RegistrationDetails registrationdetails,
			BindingResult result, HttpServletRequest request) {
		
		registrationdetails.setRole("USER_ROLE");
		registrationdetails.setEnabled(true);

		String email = registrationdetails.getEmailId();
		registerDAO.registerUser(registrationdetails);
		return "redirect:/login";

	}

	@RequestMapping(value = "/login_success")
	public String loginCheck(Model m, HttpSession session) {
		
		String page = "";
		boolean loggedIn = false;

		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();

		String username = authentication.getName();
		System.out.println(username);

		loggedIn = true;
		session.setAttribute("loggedIn", loggedIn);
		session.setAttribute("email", username);
		RegistrationDetails registrationDetails = registerDAO.get(username);
		System.out.println(registrationDetails);
		PersonalDetails user = personalDAO.getWithRegId(registrationDetails.getUserid());

		if (user == null) {
			user = new PersonalDetails();
		}

		m.addAttribute("pdetails", user);

		return "PersonalDetails";
	}

}
