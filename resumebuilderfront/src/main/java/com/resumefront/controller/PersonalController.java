package com.resumefront.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.resumebuilder.dao.EducationalDAO;
import com.niit.resumebuilder.dao.PersonalDAO;
import com.niit.resumebuilder.dao.RegisterDAO;
import com.niit.resumebuilder.model.EducationalDetails;
import com.niit.resumebuilder.model.PersonalDetails;
import com.niit.resumebuilder.model.RegistrationDetails;

@Controller
public class PersonalController {

	@Autowired
	RegisterDAO registerDAO;

	@Autowired
	private PersonalDAO personalDAO;
	
	@Autowired
	private EducationalDAO educationalDAO;

/*	@RequestMapping("/check")
	public String check(@RequestParam("email") String email, @RequestParam("password") String password) {
		System.out.println(email+" "+password);
		RegistrationDetails regDetails = registerDAO.login(email, password);

		if (regDetails != null) {
			return "redirect:/regDetails/" + regDetails.getUserid();
		}

		return "login";
	}*/

	@GetMapping("/edndetails")
	public String ednDetails(Model model) {

		model.addAttribute("edndetails", new EducationalDetails());

		return "EducationalDetails";
	}

	@GetMapping("/regDetails/{id}")
	public String personDetails(@PathVariable("id") Integer regId, Model model) {

		RegistrationDetails regDetails = registerDAO.get(regId);

		PersonalDetails personalDetails = personalDAO.get(regId);

		if (personalDetails != null) {
			model.addAttribute("pdetails", personalDetails);
		} else {
			model.addAttribute("pdetails", new PersonalDetails());
		}

		return "PersonalDetails";

	}
	
	
	@PostMapping("/pdetails")
	public String saveDetails(@ModelAttribute("pdetails") PersonalDetails personalDetails, BindingResult result,
			HttpServletRequest request, Principal principal){
		
		personalDetails.setRegdetails(registerDAO.get(principal.getName()));
		personalDAO.registerPersonalDetails(personalDetails);
		
		return "redirect:/eddetails/"+personalDetails.getUserid();
		
	}
	
	
	
	
}
