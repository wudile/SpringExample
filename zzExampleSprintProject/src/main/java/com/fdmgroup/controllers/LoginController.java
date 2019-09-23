package com.fdmgroup.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.entity.User;

@Controller

public class LoginController {

	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loadLoginPage(HttpSession session, User user) {
		if(session.getAttribute("activeUser") == null) {
			return "login";
		} else {
			return "home";
		}

	}

}
