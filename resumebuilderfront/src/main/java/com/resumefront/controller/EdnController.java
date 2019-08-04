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

import com.niit.resumebuilder.dao.EducationalDAO;
import com.niit.resumebuilder.dao.PersonalDAO;
import com.niit.resumebuilder.model.EducationalDetails;
import com.niit.resumebuilder.model.ExperienceDetails;
import com.niit.resumebuilder.model.PersonalDetails;

@Controller
public class EdnController {

	@Autowired
	EducationalDAO educationalDAO;

	@Autowired
	private PersonalDAO personalDAO;

	@GetMapping("/eddetails/{id}")
	public String educationDetails(@PathVariable("id") Integer personalDetailsId, Model model) {
		EducationalDetails eddetails = educationalDAO.getByPersonalDetailsId(personalDetailsId);
		if (eddetails != null) {
			model.addAttribute("eddetails", eddetails);
		} else {
			
			eddetails = new EducationalDetails();
			eddetails.setPdetails(personalDAO.get(personalDetailsId));
			model.addAttribute("eddetails",eddetails);
		}

		return "EducationalDetails";
	}

	@PostMapping("/eddetails")
	public String addEducationalDetails(@ModelAttribute("eddetails") EducationalDetails educationalDetails,
			Principal principal) {
	
		System.out.println(educationalDetails.getPdetails().getUserid());

		PersonalDetails personalDetails = personalDAO.get(educationalDetails.getPdetails().getUserid());
		System.out.println(personalDetails);
		/*personalDetails.setEdndetails(educationalDetails);*/
		educationalDetails.setPdetails(personalDetails);
		educationalDAO.registerEducationDetails(educationalDetails);

		return "redirect:/expdetails/" + educationalDetails.getPdetails().getUserid();
	}
}
