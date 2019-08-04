package com.resumefront.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

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

import com.niit.resumebuilder.dao.ExperienceDAO;
import com.niit.resumebuilder.dao.PersonalDAO;
import com.niit.resumebuilder.model.EducationalDetails;
import com.niit.resumebuilder.model.ExperienceDetails;
import com.niit.resumebuilder.model.PersonalDetails;

@Controller
public class ExpController {
	@Autowired
	ExperienceDAO expDAO;
	
	@Autowired
	private PersonalDAO personalDAO;
	
		
	@GetMapping("/expdetails/{id}")
	public String expDetails(@PathVariable("id")Integer pid,Model model) {
		
	ExperienceDetails expDetails =	expDAO.getWithPersonalDetailsId(pid);
		
		if(expDetails !=null) {
			model.addAttribute("expdetails", expDetails);
		}else {
			expDetails = new ExperienceDetails();
			expDetails.setPdetails(personalDAO.get(pid));
			model.addAttribute("expdetails", expDetails);
		}
		
		return "Template1";
	}
	
	@PostMapping("/expdetails")
	public String addExperienceDetails(@ModelAttribute("expdetails") ExperienceDetails experienceDetails,
			Principal principal) {
	
		System.out.println(experienceDetails.getPdetails().getUserid());

		PersonalDetails personalDetails = personalDAO.get(experienceDetails.getPdetails().getUserid());
		System.out.println(personalDetails);
		
		experienceDetails.setPdetails(personalDetails);
		expDAO.registerExperience(experienceDetails);

		return "redirect:/expdetails/" + experienceDetails.getPdetails().getUserid();
	}

}
