package com.app.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.security.model.CustomUserDetail;

@Controller
public class LoginController {	
	
	@RequestMapping(value="/")
	public String defaultM() {
		return "login";
	}
	
	@RequestMapping(value="/success")
	public String home1() {
		return "success";
	}
	
	@RequestMapping(value="/failure")
	public String error() {
		return "failure";
	}
	
	@RequestMapping(value="/registration")
	public ModelAndView registration() {
		CustomUserDetail userDetails = (CustomUserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView model=new ModelAndView();
		model.addObject("registration");
		model.addObject("LoggedInUser", userDetails.getUsername());
		model.addObject("Roles", userDetails.getAuthorities());
		return model;
	}
	
	
}

